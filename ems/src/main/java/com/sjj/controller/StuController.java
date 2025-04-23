package com.sjj.controller;

import com.sjj.entity.Stu;
import com.sjj.service.StuService;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.List;

@Controller
public class StuController {

    @Autowired
    private StuService stuService;

    // ====================== 显示添加学生页面 ======================
    @GetMapping("/emp/addstu")
    public String showAddStudentPage() {
        return "emp/addstu"; // 直接返回模板，无需重定向
    }

    // ====================== 处理添加学生请求 ======================
    @PostMapping("/emp/addstu")
    public String addStudent(Stu stu, RedirectAttributes redirectAttributes) {
        try {
            stuService.save(stu);
            redirectAttributes.addFlashAttribute("success", "学生添加成功");
            return "redirect:/emp/student"; // 跳转到学生列表页
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "添加失败: " + e.getMessage());
            return "redirect:/emp/addstu"; // 失败时返回添加页
        }
    }
    @GetMapping("/emp/student")
    public String listStudents(
            @RequestParam(value = "id", required = false) Integer id,  // 接收可选的 id 参数
            Model model) {

        if (id != null) {
            // 按 id 查询学生
            Stu student = stuService.findById(id);
            if (student != null) {
                // 将单个学生包装为列表，保持前端模板兼容性
                model.addAttribute("students", Collections.singletonList(student));
            } else {
                // 未找到时的错误提示
                model.addAttribute("error", "未找到ID为 " + id + " 的学生");
                model.addAttribute("students", Collections.emptyList());
            }
        } else {
            // 未传 id 时查询全部学生
            model.addAttribute("students", stuService.findAll());
        }
        return "emp/student";
    }
    // ====================== 处理修改学生请求 ======================
    @GetMapping("/emp/updatestu")
    public String showUpdatePage(@RequestParam("id") Integer id, Model model) {
        Stu stu = stuService.findById(id);
        model.addAttribute("student", stu);
        return "emp/updatestu";
    }

    @PostMapping("/emp/updatestu")
    public String updStudent(Stu stu, RedirectAttributes redirectAttributes) {
        try {
            stuService.update(stu);
            redirectAttributes.addFlashAttribute("success", "学生修改成功");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "修改失败: " + e.getMessage());
            return "redirect:/emp/updatestu?id=" + stu.getId();
        }
        return "redirect:/emp/student";
    }

    @GetMapping("/emp/delete/{id}")
    public String deleteStudent(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
        try {
            stuService.delete(id);
            redirectAttributes.addFlashAttribute("success", "学生删除成功");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "删除失败: " + e.getMessage());
        }
        return "redirect:/emp/student";
    }

    @GetMapping("/emp/export")
    public void exportToExcel(HttpServletResponse response) throws Exception {
        // 1. 设置响应头
        response.setContentType(
                "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        String fileName = URLEncoder.encode("学生信息.xlsx", "UTF-8");
        response.setHeader("Content-Disposition",
                "attachment;filename=\"" + fileName + "\"");

        // 2. 从数据库查询数据
        List<Stu> list = stuService.findAll();

        // 3. 使用 POI 创建 Excel
        Workbook wb = new XSSFWorkbook();
        Sheet sheet = wb.createSheet("学生信息");

        // 3.1 写表头
        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("ID");
        header.createCell(1).setCellValue("姓名");
        header.createCell(2).setCellValue("性别");
        header.createCell(3).setCellValue("年龄");

        // 3.2 写数据行
        for (int i = 0; i < list.size(); i++) {
            Stu s = list.get(i);
            Row row = sheet.createRow(i + 1);
            row.createCell(0).setCellValue(s.getId());
            row.createCell(1).setCellValue(s.getName());
            row.createCell(2).setCellValue(s.getGender());
            row.createCell(3).setCellValue(s.getAge());
        }

        // 4. 输出到客户端
        wb.write(response.getOutputStream());
        wb.close();
    }

}
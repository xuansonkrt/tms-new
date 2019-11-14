package application.demo.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import application.common.Response;
import application.demo.bo.HocLop;
import application.demo.bo.LopHocPhan;
import application.demo.bo.SinhVien;
import application.demo.dao.CartDAO;
import application.demo.dao.HocLopDAO;
import application.demo.dao.HocPhanDAO;
import application.demo.dao.LopHocPhanDAO;
import application.demo.dao.SinhVienDAO;

@RestController
@RequestMapping(path = "/api/cart")
public class CartAPIController {
    @Autowired
    private CartDAO cartDAO;
    
    @Autowired
    private HocPhanDAO hocPhanDAO;
    @Autowired
    private SinhVienDAO sinhVienDAO;
    
    @Autowired
    private LopHocPhanDAO lopHocPhanDAO;
    
    @Autowired
    private HocLopDAO hocLopDAO;
    
    @GetMapping("/demo")
    public @ResponseBody Response demo(Long index) {
        Response response = new Response();
        response.setStatus("OK");
        response.setData(cartDAO.getAll());
        return response;
    }
    
    @GetMapping("/fake")
    public @ResponseBody Response fake() {
        String[] list = new String[] {"Giải tích 1"
                ,"Giải tích 2"
                ,"Hình họa học hình"
                ,"Cơ sở dữ liệu"
                ,"Cơ sở dữ liệu nâng cao"
                ,"Phân tích & Thiết kế giải thuật"
                ,"Thực tập kỹ thuật lập trình"
                ,"Thực tập nhóm"
                ,"Lập trình nâng cao"
                ,"Công nghệ Web"
                ,"Trí tuệ nhân tạo"
                ,"Tương tác người máy"
                ,"Lập trình cơ bản"
                ,"Công nghệ phần mềm"
                ,"Phương pháp nghiên cứu IT"
                ,"Kỹ thuật lập trình"};
        /*
         * for(int i=0; i<list.length; i++) {
         * HocPhan bo = new HocPhan();
         * bo.setMa(String.format("%06d", i+1));
         * bo.setTen(list[i]);
         * bo.setSoTinChi(i%4+1);
         * hocPhanDAO.save(bo);
         * }
         */
        Response response = new Response();
        response.setStatus("OK");
        response.setData(hocPhanDAO.getAll());
        return response;
    }
    
    @GetMapping("/fake2")
    public @ResponseBody Response fake2() {
        
          for (int i = 0; i < 20; i++) {
          SinhVien bo = new SinhVien();
          bo.setTen(String.format("Nguyen Van A%s", i+40) );
          bo.setMa(String.format("SV%04d", i+40));
          bo.setIdLopCN(1);
          sinhVienDAO.save(bo);
          }
         
        Response response = new Response();
        response.setStatus("OK");
        response.setData(sinhVienDAO.getAll());
        return response;
    }
    
    
    @GetMapping("/fake3")
    public @ResponseBody Response fake3() {
        String[] list = new String[] {"Giải tích 1"
                ,"Giải tích 2"
                ,"Hình họa học hình"
                ,"Cơ sở dữ liệu"
                ,"Cơ sở dữ liệu nâng cao"
                ,"Phân tích & Thiết kế giải thuật"
                ,"Thực tập kỹ thuật lập trình"
                ,"Thực tập nhóm"
                ,"Lập trình nâng cao"
                ,"Công nghệ Web"
                ,"Trí tuệ nhân tạo"
                ,"Tương tác người máy"
                ,"Lập trình cơ bản"
                ,"Công nghệ phần mềm"
                ,"Phương pháp nghiên cứu IT"
                ,"Kỹ thuật lập trình"};
        
//         for(int i=0; i<list.length; i++) {
//             LopHocPhan bo = new LopHocPhan();
//             bo.setMa(String.format("%06d", i+1));
//             bo.setTen(list[i]);
//             bo.setIdHocPhan(i+1);
//             bo.setTen(list[i]+i);
//             bo.setIdHocKy(i%2+1);
//             lopHocPhanDAO.save(bo);
//         }
         
        Response response = new Response();
        response.setStatus("OK");
        response.setData(lopHocPhanDAO.getAll());
        return response;
    }
    
    @GetMapping("/fake4")
    public @ResponseBody Response fake4() {
        Double[] point = new Double[] {0D,1.0,1.5,2.0,2.5,3.0,3.5,3.7,4.0};
        /*
         * for (int i = 0; i < 20; i++) {
         * SinhVien bo = new SinhVien();
         * bo.setTen(String.format("Nguyen Van C%s", i) );
         * bo.setMa(String.format("SV2%03d", i));
         * bo.setIdLopCN(3);
         * sinhVienDAO.save(bo);
         * }
         */
        List<SinhVien> lstSinhVien = sinhVienDAO.findByIdLopCN(1);
        List<LopHocPhan> lstLopHocPhan = lopHocPhanDAO.findByIdHocKy(1);
        
        int randomNum = ThreadLocalRandom.current().nextInt(5, 10 + 1);
        for (SinhVien sv : lstSinhVien) {
            int somon = ThreadLocalRandom.current().nextInt(5, 10);
            Set<Integer> listlhp = new HashSet<Integer>();
            for (int i = 0; i < somon; i++) {
                listlhp.add(ThreadLocalRandom.current().nextInt(0, lstLopHocPhan.size()));
            }
            for (Integer integer : listlhp) {
                HocLop hl = new HocLop();
                hl.setIdSinhVien(sv.getId());
                hl.setIdLopHocPhan(lstLopHocPhan.get(integer).getId());
                hl.setDiemHS4(point[ThreadLocalRandom.current().nextInt(0, 9)]);
                hocLopDAO.save(hl);
            }
        }
        
        
        
        Response response = new Response();
        response.setStatus("OK");
        response.setData(hocLopDAO.findAll());
        return response;
    }
}

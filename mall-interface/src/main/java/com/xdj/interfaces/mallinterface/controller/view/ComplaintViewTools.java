package com.xdj.interfaces.mallinterface.controller.view;

import com.xdj.interfaces.mallinterface.service.IComplaintService;
import com.xdj.interfaces.mallinterface.service.IComplaintSubjectService;
import com.xdj.interfaces.mallinterface.service.IOrderFormService;
import com.xdj.www.entity.ShoppingComplaintWithBLOBs;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class ComplaintViewTools {
    @Resource
    private IComplaintService complaintService;
    @Resource
    private IComplaintSubjectService complaintSubjectService;

    public final void addCss(List<ShoppingComplaintWithBLOBs> complaints){
        if(complaints != null){
            for(ShoppingComplaintWithBLOBs c: complaints){
                addCs(c);
            }
        }
    }

    private void addCs(ShoppingComplaintWithBLOBs c) {
        if(c != null){
            if(c.getCsId() != null){
                c.setCs(complaintSubjectService.getObjById(c.getCsId()));
            }
        }
    }


}

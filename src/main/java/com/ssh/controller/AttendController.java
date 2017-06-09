package com.ssh.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ssh.entity.Attend;
import com.ssh.model.PageBean;
import com.ssh.service.AttendService;
import com.ssh.service.TestService;
import com.ssh.util.JsonUtil;

@Controller
@RequestMapping(value = "attend")
public class AttendController {
    private static final Logger LOGGER = LoggerFactory
            .getLogger(AttendController.class);

    @Autowired
    private TestService baseService;
    @Autowired
    private AttendService attendService;

    @RequestMapping(value = "attend")
    public String attend() {
        LOGGER.info("attend");
        return "attend/attend";
    }

    @RequestMapping(value = "getAtdList")
    @ResponseBody
    public String getAtdList(@RequestParam Map<String, String> params) {
        LOGGER.info("getAtdList-params:" + params.toString());
        PageBean<Attend> atdPage = attendService.getAttendPage(params);
        return JsonUtil.PageJson(atdPage);
    }

    @RequestMapping(value = "getAtd")
    public ModelAndView getAtd(@RequestParam Map<String, String> params) {
        LOGGER.info("getAtd-params:" + params.toString());
        ModelAndView view = new ModelAndView();
        String id = params.get("id");
        if (!"".equals(id) && id != null) {
            Attend atd = attendService.getAttend(params.get("id"));
            view.addObject("atd", atd);
            view.addObject("editType", "edit");
        } else {
            view.addObject("editType", "add");
        }
        view.setViewName("attend/attendEdit");
        return view;
    }

    @RequestMapping(value = "editAtd")
    @ResponseBody
    public String editAtd(Attend attend, String editType) {
        LOGGER.info("getAtd-attend:" + attend.toString());
        LOGGER.info("getAtd-editType:" + editType);
        boolean atdPage = false;
        if ("add".equals(editType)) {
            atdPage = attendService.addAttend(attend, "user");
        } else {
            atdPage = attendService.editAttend(attend, "zh");
        }
        return JsonUtil.JsonSuccess(atdPage, atdPage);
    }

    @RequestMapping(value = "removeAtd")
    @ResponseBody
    public String removeAtd(@RequestParam String[] ids) {
        // LOGGER.info("getAtd-attend:" + attend.toString());
        // Long id = attend.getId();
        LOGGER.info("removeAtd-params:" + ids.toString());
        if (ids != null && ids.length > 0) {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("ids", ids);
            // int atdBool = false;
            int atdBool = attendService.removeAttend(params, "user");
            return JsonUtil.JsonSuccess(true, atdBool);
        } else {
            return JsonUtil.JsonSuccess(false, 0);
        }
    }

    @RequestMapping(value = "work")
    public String work() {
        LOGGER.info("work");
        return "attend/work";
    }

}

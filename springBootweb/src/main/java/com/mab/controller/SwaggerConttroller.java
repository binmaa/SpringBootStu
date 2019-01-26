package com.mab.controller;

import com.mab.bean.Employee;
//import com.thunisoft.laaio.dao.TMsAjDao;
//import com.thunisoft.laaio.model.Tzzlamsaj;
//import com.thunisoft.laaio.util.GyUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/Swagger")
@Api(value = "SwaggerConttroller测试swagger注解的的控制器 打个样")
public class SwaggerConttroller {
/*    @Autowired
    private TMsAjDao tMsAjDao;*/

    /**
     * 通过案件编号获取案件信息 paramType 查询类型
     * @param CBh
     * @return
     */
    @ResponseBody
    @GetMapping(value = "/getAjByBh")
    @ApiOperation(value = "通过案件编号查询案件", notes = "案件编号")
    @ApiImplicitParam(paramType = "query", name = "CBh", value = "案件编号", required = true, dataType = "String")
    public Object getAjByBh(@RequestParam String CBh) {
        Map<String, Object> map = new HashMap<String, Object>();
//        Tzzlamsaj msAjOne = tMsAjDao.selectAjxxByCbh(CBh);
//        map.put("aj", msAjOne);
        return map;
    }

    /**
     * 通过案件编号获取案件信息 方式2
     * @param CBh
     * @return
     */
    @ResponseBody
    @ApiOperation(value = "获取案件2",notes = "通过案件编号")
    //    @ApiImplicitParam(name = "CBh", value = "通过案件编号", required = true, paramType = "path", dataType = "String") //注意：paramType需要指定为path,不然不能正常获取
    @GetMapping(value = "/getAjByBh2/{CBh}")
    public Object getAjByBh2(@ApiParam(value = "案件编号",required = true)@PathVariable String CBh ){
        Map<String, Object> map = new HashMap<String, Object>();
//        Tzzlamsaj msAjOne = tMsAjDao.selectAjxxByCbh(CBh);
//        map.put("aj2", msAjOne);
        return map;
    }

    /**
     * 创建新案件
     * @param employee
     * @return
     */
    @ResponseBody
    @ApiOperation(value = "新建案件",notes = "创建一个新案件")
    @PutMapping(value = "/insertMsAj")
    public Object insertMsAj(@ApiParam(value="案件信息",required = true) @RequestBody Employee employee){
//        String uuid = GyUtil.getUuid();
//        tzzlamsaj.setcBh(uuid);
//        tMsAjDao.insertAjbh(tzzlamsaj);
        return "保存成功uuid:";
    }

    /**
     * 创建新案件
     * @param employee
     * @return
     */
    @ResponseBody
    @ApiOperation(value = "新建案件",notes = "创建一个新案件")
    @ApiImplicitParam(name = "employee", value = "案件信息", required = true, paramType = "body", dataType = "Employee") //注意：paramType需要指定为body,不然不能正常获取
    @PutMapping(value = "/insertMsAj2")
    public Object insertMsAj2(@RequestBody Employee employee){
//        String uuid = GyUtil.getUuid();
//        tzzlamsaj.setcBh(uuid);
//        tMsAjDao.insertAjbh(tzzlamsaj);
        return "保存成功uuid:";
    }
}
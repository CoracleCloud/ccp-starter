package com.github.wxiaoqi.security.admin.rest;

import com.github.wxiaoqi.security.admin.biz.PositionBiz;
import com.github.wxiaoqi.security.admin.entity.Position;
import com.github.wxiaoqi.security.admin.entity.User;
import com.github.wxiaoqi.security.admin.vo.DepartTree;
import com.github.wxiaoqi.security.admin.vo.GroupTree;
import com.coracle.cloud.security.auth.client.annotation.CheckClientToken;
import com.coracle.cloud.security.auth.client.annotation.CheckUserToken;
import com.coracle.cloud.security.common.msg.ObjectRestResponse;
import com.coracle.cloud.security.common.rest.BaseController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("position")
@CheckUserToken
@CheckClientToken
public class PositionController extends BaseController<PositionBiz, Position> {

    @RequestMapping(value = "/{id}/user", method = RequestMethod.PUT)
    @ResponseBody
    public ObjectRestResponse modifyUsers(@PathVariable String id, String users) {
        baseBiz.modifyPositionUsers(id, users);
        return new ObjectRestResponse();
    }

    @RequestMapping(value = "/{id}/user", method = RequestMethod.GET)
    @ResponseBody
    public ObjectRestResponse<List<User>> getUsers(@PathVariable("id") String positionId) {
        return new ObjectRestResponse<List<User>>().data(baseBiz.getPositionUsers(positionId));
    }

    @RequestMapping(value = "/{id}/group", method = RequestMethod.PUT)
    @ResponseBody
    public ObjectRestResponse modifyRoles(@PathVariable String id, String groups) {
        baseBiz.modifyPositionGroups(id, groups);
        return new ObjectRestResponse();
    }

    @RequestMapping(value = "/{id}/group", method = RequestMethod.GET)
    @ResponseBody
    public ObjectRestResponse<List<GroupTree>> getRoles(@PathVariable("id") String positionId) {
        return new ObjectRestResponse<List<GroupTree>>().data(baseBiz.getPositionGroups(positionId));
    }

    @RequestMapping(value = "/{id}/depart", method = RequestMethod.PUT)
    @ResponseBody
    public ObjectRestResponse modifyDeparts(@PathVariable String id, String departs) {
        baseBiz.modifyPositionDeparts(id, departs);
        return new ObjectRestResponse();
    }

    @RequestMapping(value = "/{id}/depart", method = RequestMethod.GET)
    @ResponseBody
    public ObjectRestResponse<List<DepartTree>> getDeparts(@PathVariable("id") String positionId) {
        return new ObjectRestResponse<List<DepartTree>>().data(baseBiz.getPositionDeparts(positionId));
    }
}

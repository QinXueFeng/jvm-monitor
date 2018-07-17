<%--
 * 
 * @author qxf
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>${formDto.newly?'添加':'编辑'} 线程</title>
</head>
<body>
<div>
    <div class="row">
        <div class="col-md-12">
            <h4>${formDto.newly?'添加':'编辑'} 线程</h4>
            <form:form commandName="formDto" cssClass="form-horizontal">
            <div class="form-group">
                    <label for="instanceName" class="col-sm-2 control-label">线程名称</label>

                    <div class="col-sm-8">
                        <form:input path="threadName" id="threadName" cssClass="form-control"
                                    placeholder="请输入实例名称" required="true" maxlength="255"/>
                        <p class="help-block">对该监控的称呼</p>
                        <form:errors path="instanceName" cssClass="text-danger"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="instanceName" class="col-sm-2 control-label">线程真实名称</label>

                    <div class="col-sm-8">
                        <form:input path="instanceName" id="instanceName" cssClass="form-control"
                                    placeholder="请输入线程名称" required="true" maxlength="255"/>
                        <p class="help-block">对该监控的称呼, 对应服务器线程名称,必须唯一</p>
                        <form:errors path="instanceName" cssClass="text-danger"/>
                    </div>
                </div>
                
                <div class="form-group">
                    <label for="monitorUrl" class="col-sm-2 control-label">服务器url</label>

                    <div class="col-sm-8">
                        <form:input path="monitorUrl" id="monitorUrl" cssClass="form-control"
                                    placeholder="http://..." maxlength="255" required="true"/>
                        <p class="help-block">监控URL以 'http' 或 'https' 开头, 如: 'http://andaily.com/test.html'</p>
                        <form:errors path="monitorUrl" cssClass="text-danger"/>
                    </div>
                </div>
                 <div class="form-group">
                    <label for="monitorUrl" class="col-sm-2 control-label">频率</label>

                    <div class="col-sm-8">
                        <form:select path="frequency" id="frequency" cssClass="form-control">
                            <form:options items="${formDto.frequencies}" itemLabel="label" itemValue="value"/>
                        </form:select>
                        <p class="help-block">两次监控请求之间的间隔时间</p>
                        <form:errors path="frequency" cssClass="text-danger"/>
                    </div>
                </div>
               <%-- <div class="form-group">
                    <label class="col-sm-2 control-label">连续失败次数</label>

                    <div class="col-sm-8">
                        <form:select path="continueFailedTimes" cssClass="form-control">
                            <c:forEach begin="1" end="5" var="step">
                                <form:option value="${step}" label="${step}"/>
                            </c:forEach>
                        </form:select>
                        <p class="help-block">该参数用于设定在连续几次连接失败后才发送提醒, 默认为2;
                            一般在检测状态不正常时, 有可能是因为网络故障(如常见的:丢包,dns故障,闪断)而出现问题, 这时一发现不正常就发送提醒的意义不大</p>
                        <form:errors path="continueFailedTimes" cssClass="text-danger"/>
                    </div>
                </div> --%>
                <div class="form-group">
                    <label for="email" class="col-sm-2 control-label">接收提醒邮箱</label>

                    <div class="col-sm-8">
                        <form:input path="email" id="email" cssClass="form-control"
                                    placeholder="请输入邮箱" required="true"/>
                        <p class="help-block">当心跳监控不正常时,HB将向添加的邮箱发送邮件提醒; 多个邮箱地址用分号(;)分隔</p>
                        <form:errors path="email" cssClass="text-danger"/>
                    </div>
                </div>
                <%-- <div class="form-group">
                    <label class="col-sm-2 control-label">私有实例</label>

                    <div class="col-sm-8">
                        <form:checkbox path="privateInstance"/>
                        <p class="help-block">若该实例只允许自己登录后查看,请勾选上</p>
                        <form:errors path="privateInstance" cssClass="text-danger"/>
                    </div>
                </div> --%>
                <div class="form-group">
                    <label for="remark" class="col-sm-2 control-label">备注</label>

                    <div class="col-sm-8">
                        <form:textarea path="remark" id="remark" rows="3"
                                       cssClass="form-control"
                                       placeholder="请输入关于该实例的备注信息"/>
                        <p class="help-block">关于该实例的备注信息; (可选)</p>
                        <form:errors path="remark" cssClass="text-danger"/>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-primary"><em class="fui-check-circle"></em> 保存</button>
                        &nbsp;<a href="list.hb">取消</a>
                    </div>
                </div>
            </form:form>
        </div>
    </div>
</div>

<script>
    $(function () {
        new InstanceForm();
    });
</script>
</body>
</html>
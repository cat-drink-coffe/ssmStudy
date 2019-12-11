<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
登录成功！欢迎你 ${emp.name}
<a href="<%=request.getContextPath() %>/myTask">我的任务</a>

<c:if test="${!empty list }">
    <table border="1" align="center">
        <tr>
            <th>ID</th>
            <th>请假天数</th>
            <th>请假事由</th>
            <th>请假原因</th>
            <th>请假时间</th>
            <th>请假人</th>
            <th>请假状态</th>
            <th>操作</th>
        </tr>

        <c:forEach items="${list}" var="leaveBill">
            <tr>
                <td>${leaveBill.id }</td>
                <td>${leaveBill.days }</td>
                <td>${leaveBill.content }</td>
                <td>${leaveBill.remark }</td>
                <td>${leaveBill.leaveDate }</td>
                <td>${leaveBill.name }</td>
                <c:if test="${leaveBill.status == 0}">
                    <td>初始录入</td>
                </c:if>
                <c:if test="${leaveBill.status == 1}">
                    <td>审批中</td>
                </c:if>
                <c:if test="${leaveBill.status == 2}">
                    <td>审批完成</td>
                </c:if>
                <td>
                    <c:if test="${leaveBill.status == 0}">
                        <a href="<%=request.getContextPath() %>/saveStartProcess?id=${leaveBill.id }">发起请假申请</a>
                    </c:if>
                    <c:if test="${leaveBill.status == 2}">
                        <a href="<%=request.getContextPath() %>/queryTaskHistory?id=${leaveBill.id }">查看审核记录</a>
                    </c:if>
                </td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>
<%@ page  isELIgnored="false"  %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<h1 align="center">All Student Records</h1>

<c:choose>
   <c:when test="${!empty studentList}">
       <table  border="1"  bgcolor="cyan"  align="center"> 
                <tr bgcolor="pink">
                   <th>Student Id </th> <th>First Name </th> <th>Last Name </th> <th>Mobile</th> <th>Email </th>
                    <th>Project Name </th> <th>Duration </th>
                </tr>
                <c:forEach var="student"  items="${studentList}">
                     <tr>
                     	<td>${student.id}  </td>
                        <td>${student.fname}  </td>
                        <td>${student.lname}  </td>
                        <td>${student.mobile}  </td>
                        <td>${student.email}  </td>
                        <td>${student.project.pname}  </td>
                        <td>${student.project.duration}  </td>
                     </tr>
                </c:forEach>
                </table>
                 <br><br>
    </c:when>
   <c:otherwise>
           <h1 style="color:red;text-align:center"> Records  not  found </h1>
   </c:otherwise>
</c:choose>
     <blink><h1 style="color:green;text-align:center">${resultMsg}</h1> </blink>
 
 <br>
    <h1 style="text-align:center"><a href="./">Home </a></h1>
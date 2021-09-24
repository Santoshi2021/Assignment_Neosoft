<%@ page isELIgnored="false" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<h1 style="color:blue;text-align:center">Register Student</h1>

<script type="text/javascript" src="js/form_validation.js"></script>

<form:form  modelAttribute="student"  onsubmit="return validate(this)">
  <p style="color:red;text-align:center"> <form:errors path="*"/>
    </p>
    <table border="0" bgcolor="cyan" align="center">
        <tr>
           <td>  Student first name :: </td>
           <td>  <form:input path="fname"/><form:errors  path="fname" cssStyle="color:red"/><span id="fnameErr" style="color:red"></span> </td>
        </tr>
        <tr>
           <td>  Student last name :: </td>
           <td>  <form:input path="lname"/><form:errors  path="lname" cssStyle="color:red"/><span id="lnameErr" style="color:red"></span> </td>
        </tr>
        <tr>
           <td>  Student mobile number :: </td>
           <td>  <form:input path="mobile"/><form:errors  path="mobile" cssStyle="color:red"/><span id="mobileErr" style="color:red"></span> </td>
        </tr>
        <tr>
           <td>  Student email id :: </td>
           <td>  <form:input path="email"/><form:errors  path="email" cssStyle="color:red"/><span id="emailErr" style="color:red"></span> </td>
        </tr>
        
        <tr>
           <td>  Project name :: </td>
           <td>  <form:input path="project.pname"/><form:errors  path="project.pname" cssStyle="color:red"/><span id="pnameErr" style="color:red"></span> </td>
        </tr>
        
        <tr>
           <td>  Project duration :: </td>
           <td>  <form:input path="project.duration"/><form:errors  path="project.duration" cssStyle="color:red"/><span id="durationErr" style="color:red"></span> </td>
        </tr>
        <tr>
           <td> <button type = "submit"> Submit </button> </td>
           <td> <button  type = "reset" > Reset </button>  </td>
        </tr>
    </table>
</form:form>

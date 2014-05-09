<%@ page language="java" contentType="text/html" %>
<%@ page import="java.util.*" %>
<%@ page session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>Bison Maps - Get Directions</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
</head>
<body>
<table width="75%" border="0" cellpadding="0" cellspacing="0">
  <tr bgcolor="#FF0000"> 
    <td height="42"><div align="center"><font color="#FFFFFF"><strong><a href="/directions.jsp">Get 
        Directions</a></strong></font></div></td>
    <td><div align="center"><font color="#FFFFFF"><strong><a href="/resources.jsp">Find 
        Resources</a></strong></font></div></td>
    <td><div align="center"><font color="#FFFFFF"><strong><a href="/showBuildings.jsp">Show 
        Buildings</a></strong></font></div></td>
    <td><div align="center"><font color="#FFFFFF"><strong><a href="/showResources.jsp">Show 
        Campus Resources</a></strong></font></div></td>
    <td><div align="center"><font color="#FFFFFF"><strong><a href="/showDepartments.jsp">Show 
        Departments</a></strong></font></div></td>
  </tr>
  <tr bgcolor="#FFFFFF"> 
    <td bgcolor="#FF0000">&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr bgcolor="#000099"> 
    <td colspan="5" bordercolor="0"><div align="center"><strong><font color="#FFFFFF" size="6">Get 
        Directions </font></strong></div></td>
  </tr>
  <tr bgcolor="#000099"> 
    <td height="252" colspan="5" bordercolor="0"><div align="center">
        <table width="75%" border="1">
          <tr>
            <td><font color="#FFFFFF">Starting Location (Building): </font></td>
            <td><form name="form1" method="post" action="http://safe-anchorage-5379.heroku.com/DirectionFinder">
                <select name="select">
                <option value="0">Drew Hall</option>
                  <option value="1">Burr Gymnasium</option>
                  <option value="2">Greene Memorial Stadium</option>
                  <option value="3">Cook Hall</option>
                  <option value="4">Effingham Apartments</option>
                  <option value="5">Howard Manor</option>
                  <option value="6">School of Business</option>
                  <option value="7">Cramton Auditorium</option>
                  <option value="8">Ira Aldridge Theatre</option>
                  <option value="9">Mordecai Johnson Building (Administration)</option>
                  <option value="10">Douglass Hall</option>
                  <option value="11">Childers Hall (Fine Arts)</option>
                  <option value="12">Blackburn Center</option>
                  <option value="13">Carnegie Hall</option>
                  <option value="14">Locke Hall</option>
                  <option value="15">Middle School</option>
                  <option value="16">Founders Library MSRC</option>
                  <option value="17">Founders Library UGL</option>
                  <option value="18">Thirkield Hall (Physics)</option>
                  <option value="19">Chemistry Building</option>
                  <option value="20">Mackey Building(Architecture)</option>
                  <option value="21">Downing Hall (Engineering)</option>
                  <option value="22">Howard Service Center</option>
                  <option value="23">Howard Plaza Towers (East)</option>
                  <option value="24">Howard Plaza Towers (West)</option>
                  <option value="25">Howard University Hospital</option>
                  <option value="26">Student Health Center</option>
                  <option value="27">Hospital Service Center</option>
                  <option value="28">Just Hall (Biology)</option>
                  <option value="29">Bethune Annex</option>
                  <option value="30">CB Powell Building (Communications)</option>
                  <option value="31">Center for Academic Reinforcement</option>
                  <option value="32">Dixon Building (College of Dentistry)</option>
                  <option value="33">Graduate School</option>
                  <option value="34">Howard Center/Bookstore</option>
                  <option value="35">Howard Hall</option>
                  <option value="36">Laser Chemistry Building</option>
                  <option value="37">Lindsay Hall (Social Work)</option>
                  <option value="38">Mental Health Center</option>
                  <option value="39">Miner Hall</option>
                  <option value="40">Seeley Mudd Building (College of Medicine)</option>
                  <option value="41">Numa Adams Building</option>
                  <option value="42">Ralph J Bunche Center</option>
                  <option value="43">Power Plant</option>
                  <option value="44">Rankin Chapel</option>
                  <option value="45">School of Education</option>
                  <option value="46">School of Nursing & Allied Health</option>
                  <option value="47">School of Pharmacy</option>
                  <option value="48">Tubman Quadrangle</option>
                  <option value="49">WHUT TV</option>
                  <option value="50">WHUR Radio</option>
                  <option value="-999" selected>None</option>
                </select>
              </form></td>
            <td><font color="#FFFFFF">Destination Location (Building): </font></td>
            <td><form name="form2" method="post" action="http://safe-anchorage-5379.heroku.com/DirectionFinder">
                <select name="select2">
                <option value="0">Drew Hall</option>
                  <option value="1">Burr Gymnasium</option>
                  <option value="2">Greene Memorial Stadium</option>
                  <option value="3">Cook Hall</option>
                  <option value="4">Effingham Apartments</option>
                  <option value="5">Howard Manor</option>
                  <option value="6">School of Business</option>
                  <option value="7">Cramton Auditorium</option>
                  <option value="8">Ira Aldridge Theatre</option>
                  <option value="9">Mordecai Johnson Building (Administration)</option>
                  <option value="10">Douglass Hall</option>
                  <option value="11">Childers Hall (Fine Arts)</option>
                  <option value="12">Blackburn Center</option>
                  <option value="13">Carnegie Hall</option>
                  <option value="14">Locke Hall</option>
                  <option value="15">Middle School</option>
                  <option value="16">Founders Library MSRC</option>
                  <option value="17">Founders Library UGL</option>
                  <option value="18">Thirkield Hall (Physics)</option>
                  <option value="19">Chemistry Building</option>
                  <option value="20">Mackey Building(Architecture)</option>
                  <option value="21">Downing Hall (Engineering)</option>
                  <option value="22">Howard Service Center</option>
                  <option value="23">Howard Plaza Towers (East)</option>
                  <option value="24">Howard Plaza Towers (West)</option>
                  <option value="25">Howard University Hospital</option>
                  <option value="26">Student Health Center</option>
                  <option value="27">Hospital Service Center</option>
                  <option value="28">Just Hall (Biology)</option>
                  <option value="29">Bethune Annex</option>
                  <option value="30">CB Powell Building (Communications)</option>
                  <option value="31">Center for Academic Reinforcement</option>
                  <option value="32">Dixon Building (College of Dentistry)</option>
                  <option value="33">Graduate School</option>
                  <option value="34">Howard Center/Bookstore</option>
                  <option value="35">Howard Hall</option>
                  <option value="36">Laser Chemistry Building</option>
                  <option value="37">Lindsay Hall (Social Work)</option>
                  <option value="38">Mental Health Center</option>
                  <option value="39">Miner Hall</option>
                  <option value="40">Seeley Mudd Building (College of Medicine)</option>
                  <option value="41">Numa Adams Building</option>
                  <option value="42">Ralph J Bunche Center</option>
                  <option value="43">Power Plant</option>
                  <option value="44">Rankin Chapel</option>
                  <option value="45">School of Education</option>
                  <option value="46">School of Nursing & Allied Health</option>
                  <option value="47">School of Pharmacy</option>
                  <option value="48">Tubman Quadrangle</option>
                  <option value="49">WHUT TV</option>
                  <option value="50">WHUR Radio</option>
                  <option value="-999" selected>None</option>
                </select>
              </form></td>
          </tr>
          <tr>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td><form name="form3" method="post" action="http://safe-anchorage-5379.heroku.com/DirectionFinder">
                <input type="submit" name="Submit" value="Submit">
              </form></td>
          </tr>
        </table>
      </div></td>
  </tr>
</table>
</body>
</html>
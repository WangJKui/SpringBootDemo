<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>test01</title>
</head>
<body>
       <h2>${user}</h2>
       

<#-- 自定义指令 宏-->
<#macro greet>
  <font size="+2">Hello ${user}!</font>
</#macro>

<@greet></@greet>
<@greet/>
<br>
<#macro greet1 person>
  <font size="+2">Hello ${person}!</font>
</#macro>

<@greet1 person="Fred"/> and <@greet1 person="Batman"/>

<br>

<#macro border>
  <table border=4 cellspacing=0 cellpadding=4><tr><td>
    <#nested>
  </tr></td></table>
</#macro>

<@border>The bordered text</@border>

<#macro do_thrice>
  <#nested>
  <#nested>
  <#nested>
</#macro>

<@border>
  <ul>
  <@do_thrice>
    <li><@greet1 person="Joe"/>
  </@do_thrice>
  </ul>
</@border>

<#macro do_thrice1>
  <#nested 1>
  <#nested 2>
  <#nested 3>
</#macro>
<@do_thrice1 ; xx> <#-- user-defined directive uses ";" instead of "as" -->
  ${xx} Anything. <br>
</@do_thrice1>

<#import "/lib/test_01.ftl" as my> <#-- the hash called "my" will be the "gate" -->
<@my.copyright date="1999-2002"/>
${my.mail}

</body>
</html>
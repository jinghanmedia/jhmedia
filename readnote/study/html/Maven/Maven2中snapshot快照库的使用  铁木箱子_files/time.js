// JavaScript Document
 function show_time()
 {
  var now=new Date();
  var year=now.getFullYear();
  var month=now.getMonth()+1;
  var day=now.getDate();
  var hours=now.getHours();
  var minutes=now.getMinutes();
  var seconds=now.getSeconds();
  var timeValue=year+"年"
  timeValue+=month+"月"
  timeValue+=day+"日 "
  timeValue+=(hours<=12)?"上午":"下午"
  timeValue+=(hours>12)?hours-12:hours
  timeValue+=((minutes<10)?":0":":")+minutes;
  timeValue+=((seconds<10)?":0":":")+seconds;
  document.getElementById("time").value=timeValue;
  setTimeout("show_time()",1000);
 }
function FloatTop()
{
  var obj = document.getElementById("divQQbox");
  var scrollTop = window.pageYOffset 
            || document.documentElement.scrollTop 
            || document.body.scrollTop 
            || 0; 
  obj.style.top = (parseInt(scrollTop)+130) + "px";
  obj.style.right = "0px";
  
}
FloatTop();

//�������ƶ�ʱ���ø��淽��
window.onscroll = FloatTop;

//�����С�ı��¼�
window.onresize = FloatTop;
	//FloatTop();
	
	function thisQQiframeclose()
    {
        document.getElementById("qqdiv1").style.display="none";
        document.getElementById("qqdiv2").style.display="block";
    }
    function thisQQiframeopen()
    {
       document.getElementById("qqdiv1").style.display="block";
       document.getElementById("qqdiv2").style.display="none";
    }
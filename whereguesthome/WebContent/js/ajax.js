  var xhr;
  function createXHR(){
	  if(window.XMLHttpRequest){
		 //非IE
		  xhr = new XMLHttpRequest();
	  }else{
		  //IE
		  try{
			  //高版本IE 
		   xhr=new ActiveXObject("Msxml2.XMLHTTP");  
		  }catch(e){
			  //低版本IE
			  try{
			  xhr=new ActiveXObject("Microsoft.XMLHTTP");  
			  }catch(e){
				  window.alert("您的浏览器版本过低，将不能使用Ajax技术！");
			  }
		  }
	  }
  }
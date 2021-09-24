function  validate(frm){
	
	alert("from java script:: Client side form validations");
	
	   document.getElementById("fnameErr").innerHTML="";
	   document.getElementById("lnameErr").innerHTML="";
	   document.getElementById("mobileErr").innerHTML="";
	   document.getElementById("emailErr").innerHTML="";
       
	   document.getElementById("pnameErr").innerHTML="";
	   document.getElementById("durationErr").innerHTML="";
	   
	//read form data
	let name=frm.fname.value;
	let name=frm.lname.value;
	let name=frm.mobile.value;
	let name=frm.email.value;
	let name=frm.pname.value;
	let name=frm.duration.value;

	let validationFlag=true;
	
	//form validation logics (client side)
	if(fname==""){  //required rule
	    document.getElementById("fnameErr").innerHTML="Student name is required(cs)";
           validationFlag=false;
      }
   else if(fname.length()<2){  // min length rule
	      document.getElementById("fnameErr").innerHTML="Student name must have minimum of 3 characters(cs)";
           validationFlag=false;
    }
   else if(fname.length()<16){  // min length rule
	      document.getElementById("fnameErr").innerHTML="Student name must have maximum 15 characters(cs)";
        validationFlag=false;
   }
	
	if(lname==""){  //required rule
	    document.getElementById("lnameErr").innerHTML="Student name is required(cs)";
           validationFlag=false;
      }
   else if(lname.length()<2){  // min length rule
	      document.getElementById("lnameErr").innerHTML="Student name must have minimum of 3 characters(cs)";
           validationFlag=false;
    }
   else if(lname.length()>16){  // min length rule
	      document.getElementById("lnameErr").innerHTML="Student name must have maximum 15 characters(cs)";
        validationFlag=false;
   }

	if(mobile == ""){  //required rule
	    document.getElementById("mobileErr").innerHTML="Mobile number is required(cs)";
           validationFlag=false;
      }
   else if(isNaN(mobile)){  // numeric rule
	      document.getElementById("mobileErr").innerHTML="Mobile number must be numeric value(cs)";
        validationFlag=false;
    }
  else if(mobile<7000000000 || mobile > 9999999999){  //range rule
	      document.getElementById("mobileErr").innerHTML="Mobile number must be 10 digit number(cs)";
        validationFlag=false;
  }
	
	if(email==""){  //required rule
	    document.getElementById("emailErr").innerHTML="Email id is required(cs)";
           validationFlag=false;
      }
   else if(){  // min length rule
	      document.getElementById("emailErr").innerHTML="Email id is not valid(cs)";
        validationFlag=false;
    }

	if(pname==""){  //required rule
	    document.getElementById("pnameErr").innerHTML="Project name is required(cs)";
           validationFlag=false;
      }
   else if(pname.length()<15){  // min length rule
	      document.getElementById("pnameErr").innerHTML="Project name must have minimum of 15 characters(cs)";
           validationFlag=false;
    }
   else if(pname.length()>50){  // min length rule
	      document.getElementById("pnameErr").innerHTML="Project name must have maximum 50 characters(cs)";
        validationFlag=false;
 }	
	
	if(duration == ""){  //required rule
	    document.getElementById("durationErr").innerHTML="Project duration is required(cs)";
           validationFlag=false;
      }
   else if(isNaN(duration)){  // numeric rule
	      document.getElementById("durationErr").innerHTML="Project duration must be numeric value(cs)";
        validationFlag=false;
    }
  else if(salary<0){  //range rule
	      document.getElementById("durationErr").innerHTML="Project duration must be more than 0 months(cs)";
        validationFlag=false;
  }

return validationFlag;

}
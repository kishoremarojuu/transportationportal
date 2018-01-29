/**
 * DHTML phone number validation script. Courtesy of SmartWebby.com (http://www.smartwebby.com/dhtml/)
 */

// Declaring required variables
var digits = "0123456789";
// non-digit characters which are allowed in phone numbers
var phoneNumberDelimiters = "()- ";
// characters which are allowed in international phone numbers
// (a leading + is OK)
var validWorldPhoneChars = phoneNumberDelimiters + "+";
// Minimum no of digits in an international phone no.
var minDigitsInIPhoneNumber = 10;

function isNumber(s1)
{   
	
var s=s1.value;
	var i;
var name=s1.name;
    for (i = 0; i < s.length; i++)
    {   
        // Check that current character is number.
        var c = s.charAt(i);
        if (((c < "0") || (c > "9"))) 
		{
			alert(name+" -------------------Please Enter a Number");
			s1.focus();
			return false;
	}
	
   
	}
    // All characters are numbers.
    return true;
}

function isInteger(s)
{   
	
	var i;
    for (i = 0; i < s.length; i++)
    {   
        // Check that current character is number.
        var c = s.charAt(i);
        if (((c < "0") || (c > "9"))) return false;
    }
    // All characters are numbers.
    return true;
}

function stripCharsInBag(s, bag)
{   var i;
    var returnString = "";
    // Search through string's characters one by one.
    // If character is not in bag, append to returnString.
    for (i = 0; i < s.length; i++)
    {   
        // Check that current character isn't whitespace.
        var c = s.charAt(i);
        if (bag.indexOf(c) == -1) returnString += c;
    }
    return returnString;
}

function checkInternationalPhone(strPhone){
s=stripCharsInBag(strPhone,validWorldPhoneChars);
return (isInteger(s) && s.length >= minDigitsInIPhoneNumber);
}

function ValidateForm(){
	var Phone=document.register.phoneno
	
	if ((Phone.value==null)||(Phone.value=="")){
		alert("Please Enter your Phone Number")
		Phone.focus()
		return false
	}
	if (checkInternationalPhone(Phone.value)==false){
		alert("Please Enter a Valid Phone Number")
		Phone.value=""
		Phone.focus()
		return false
	}
	return true
 }

function checkconformpassword()
{
var password=register.password.value;
var conformpassword=register.conformpassword.value

if(password!=conformpassword)
{
alert("ConformPassword does not matche with Password");
return false;
}
return true;
}

function Encrypt(theText){
output = new String;
Temp = new Array();
Temp2 = new Array();
TextSize = theText.length;
for (i = 0; i < TextSize; i++){
rnd = Math.round(Math.random() * 122) + 68;
Temp[i] = theText.charCodeAt(i) + rnd;
Temp2[i] = rnd;
}
for (i = 0; i < TextSize; i++) {
output += String.fromCharCode(Temp[i], Temp2[i]);
}
return output;
}

function strValidate(string)
{
var string1=string.value
	 
	 var testName =/^([a-z]|[A-Z]| )*$/;
		
    if(!testName.test(string1))
    {
	 alert(string.name    +    "Enter only string values");
string.focus();
        return false; 
		}
		
	
		return true;
}
function abc()
{
	
	var form=document.register
	
	form.city.focus();
	return false;
	return true;
	
}
function abc1()
{
	
	var form=document.register
	form.squest.focus();
	return false;
	return true;
}


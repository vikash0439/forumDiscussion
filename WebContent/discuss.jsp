<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <meta name="keywords" content="etoken, safnet etoken, gemalto etoken, safnet, gemalto, etoken pro, etoken 5110, etoken 5200, etoken 5700, aladin etoken, etoken pro 72k, etoken pro 32k, safnet etoken 5110, safnet etoken 5100, usb etoken, usb token, etoken driver, safnet etoken driver">
    <meta name="description" content="Gemalto SafeNet Identity and Data Protection solutions are trusted by the largest and most respected brands around the world to protect what matters most.">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <!-- Title -->
    <title>Discussions | SafeNet eToken 5110 USB Authenticator</title>

    <!-- Favicon -->
    <link rel="icon" href="img/favicon.ico">
    
    <!-- Core Stylesheet -->
    <link href="style.css" rel="stylesheet">
   
    <!-- Responsive CSS -->
    <link href="css/responsive.css" rel="stylesheet">
    
     <!-- Jquery Code -->
     <scrip src="https://code.jquery.com/jquery-3.3.1.js"></script>
         

<body>
    <!-- Preloader Start -->
    <div id="preloader">
        <div class="colorlib-load"></div>
    </div>

     <!-- ***** Header Area Start ***** -->
    <header class="header_area animated" style="background:#6f42c1;">
        <div class="container-fluid">
            <div class="row align-items-center">
                <!-- Menu Area Start -->
                <div class="col-6 col-lg-10">
                    <div class="menu_area">
                        <nav class="navbar navbar-expand-lg navbar-light">
                            <!-- Logo -->
                            <a class="col-12 col-lg-2" class="navbar-brand" href="home"><img src="img/logo.png"></a>
                            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ca-navbar" aria-controls="ca-navbar" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                            <!-- Menu Area -->
                            <div class="collapse navbar-collapse" id="ca-navbar">
                                <ul class="navbar-nav ml-auto" id="nav">
                                    <li class="nav-item"><a class="nav-link" href="home">Home</a></li>
                                    <li class="nav-item"><a class="nav-link" href="etoken">eToken</a></li>
                                    <li class="nav-item"><a class="nav-link" href="features">Features</a></li>
                                    <li class="nav-item"><a class="nav-link" href="gallery">Gallery</a></li>
                                    <li class="nav-item"><a class="nav-link" href="downloads">Download</a></li>
                                    <li class="nav-item"><a class="nav-link" href="forum">Forum</a></li>
                                </ul>
                            </div>
                        </nav>
                    </div>
                </div>
                <!-- Signup btn -->
                <div class="col-12 col-lg-2">
                    <div class="sing-up-button d-none d-lg-block">
                        <img src="img/Gemalto_Authrized_partner.png" alt="" >
                    </div>
                </div>
            </div>
        </div>
    </header>
    <!-- ***** Header Area End ***** -->
 
    
    <!-- ***** Pricing Plane Area Start *****==== -->
    <section class="pricing-plane-area section_padding_100_70 clearfix" id="pricing">
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <!-- Heading Text  --><br><br>
                    <div class="section-heading text-center">
                        <h2>Discussions</h2>
                        <div class="line-shape"></div>
                        
                    </div>
                </div>
            </div>
            <div style="backgroung-color:white">
              <p>AUTHOR:  ${model.f.name}   &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; POSTED ON: ${model.f.date}</p><hr>${model.f.message} 
            </div>
            <div class="contact_from">
            <hr>
            <!-- *** Reply Section here *** -->
      <table class="table table-bordered">
        <thead> </thead>              
        <c:forEach var="e" items="${model.r}">
        <tbody>			
       <tr>     
	       <td style="text-align: right;">
			<p>${e.message}</p><small style="color:#6f42c1"> Comment by: ${e.name} </small>	
		   </td> 		          
       </tr>
       </tbody> 
       </c:forEach>
      </table>
      <!-- Reply Section ends here *** -->
            <hr>
            <div class="col-12">
                    <!-- Heading Text  --><br><br>
                    <div class="section-heading text-center">
                        <h4 style="color:#6f42c1;">Leave A Reply</h4>
                        <p>Your email address will not be published.</p>
                        <div class="line-shape"></div>
                        
                    </div>
                </div>
               <form name="replyForm" method="post" accept-charset="utf-8">
                            <!-- Message Input Area Start -->
                            <div class="contact_input_area">
                                <div class="row">
                                    <!-- Single Input Area Start -->
                                        <input type="hidden" name="forumid" value="${model.f.forumid}">
                                     
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <input type="text" class="form-control" name="name" id="name" placeholder="Your Name" required>
                                        </div>
                                    </div>
                                    <!-- Single Input Area Start -->
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <input type="email" class="form-control" name="email" id="email" placeholder="Your Email Id" required>
                                        </div>
                                    </div>
                                    <!-- Single Input Area Start -->
                                    <div class="col-9">
                                        <div class="form-group">
                                            <textarea name="comment" class="form-control" id="message" cols="30" rows="4" placeholder="Add a Comment" required></textarea>
                                        </div>
                                    </div>
                                    <!-- Single Input Area Start -->
                                    <div class="col-3">
                                        <button type="submit" class="btn submit-btn">Reply</button>
                                    </div>
                                </div>
                            </div>
                            <!-- Message Input Area End -->                            
                     </form>   
                  <hr>            
            </div>
        </div>
    </section>
    <!-- ***** Pricing Plane Area End ***** -->
   <div id="resultContainer"></div>
    
    <!-- ***** Footer Area Start ***** -->
    <footer class="footer-social-icon text-center section_padding_70 clearfix">
        <!-- footer logo -->
        <div class="footer-text">
            <img src="img/logo.png" height="50px";>
        </div>
        <!-- social icon-->
        <div class="footer-social-icon">
            <a href="https://www.facebook.com/safenet5110/" target="id_blank"><i class="fa fa-facebook" aria-hidden="true"></i></a>          
        </div>
        <div class="footer-menu">
            <nav>
                <ul>
                    <li><a href="downloads">Download</a></li>
                    <li><a href="forum">Discussion Forum</a></li>
                    <li><a href="contact">Contact Us</a></li>
                </ul>
            </nav>
        </div>
        <!-- Foooter Text-->
        <div class="copyright-text">
            <p>Copyright 2018 USBToken.in. Developed by <a href="https://silverbridge.co.in" target="_blank">SilverBridge Advisors</a></p>
        </div>
    </footer>
    <!-- ***** Footer Area Start ***** -->
      
    <!-- Jquery-2.2.4 JS -->
    <script src="js/jquery-2.2.4.min.js"></script>
    <script type="text/javascript" charset="utf8" src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.2.min.js"></script>
    <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
  <script>
  $(function(){
    $("#example").dataTable();
  })
  </script>
     
    <!-- Popper js -->
    <script src="js/popper.min.js"></script>
    <!-- Bootstrap-4 Beta JS -->
    <script src="js/bootstrap.min.js"></script>
    <!-- All Plugins JS -->
    <script src="js/plugins.js"></script>
    <!-- Slick Slider Js-->
    <script src="js/slick.min.js"></script>
    <!-- Footer Reveal JS -->
    <script src="js/footer-reveal.min.js"></script>
    <!-- Active JS -->
    <script src="js/active.js"></script>
      <script type="text/javascript">
		$(function() {
		   /*  Submit form using Ajax */
		   $('button[type=submit]').click(function(e) {
			   //Prevent default submission of form
			      e.preventDefault();
 			   var forumid=document.replyForm.forumid.value;
 			   console.log(forumid);
		       $.ajax({
		         url : 'reportAjax',
		         data : $('form[name=replyForm]').serialize(),
		         success : function(res) {
		                $('#resultContainer').html(res); 
		                setTimeout(function(){// wait for 5 secs(2)
		                    location.reload(); // then reload the page.(3)
		               }, 1000); 
		            },
		            error: function(e){
			        	alert("error");
			     }
		      })
		   });
		});
	</script>  
</body>
</html>
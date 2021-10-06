<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/registerpage.css">
    <jsp:include page="headerPage.jsp"/>
</head>
<body>
<jsp:include page="navbar.jsp"></jsp:include>
<section class="h-100 h-custom gradient-custom-2">
    <div class="container py-5 h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-12">
                <div class="card card-registration card-registration-2" style="border-radius: 15px;">
                    <div class="card-body p-0">
                        <form action="signUp" name="addUser" method="post">
                            <div class="row g-0">
                                <div class="col-lg-6">
                                    <div class="p-5">
                                        <h3 class="fw-normal mb-5" style="color: #4835d4;">General Infomation</h3>
                                        <div class="row">
                                            <div class="col-md-6 mb-4 pb-2">
                                                <div class="form-outline">
                                                    <input type="text" name="firstName" id="form3Example2"
                                                           class="form-control form-control-lg"/>
                                                    <label class="form-label" for="form3Example2">First name</label>
                                                </div>
                                            </div>
                                            <div class="col-md-6 mb-4 pb-2">
                                                <div class="form-outline">
                                                    <input type="text" name="lastName" id="form3Example3"
                                                           class="form-control form-control-lg"/>
                                                    <label class="form-label" for="form3Example3">Last name</label>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-12 mb-4 pb-2">
                                                <div class="form-outline">
                                                    <input type="text" name="login" id="form3Example4"
                                                           class="form-control form-control-lg"/>
                                                    <label class="form-label" for="form3Example4">Login</label>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-12 mb-4 pb-2">
                                                <div class="form-outline">
                                                    <input type="text" name="password" id="form3Example5"
                                                           class="form-control form-control-lg"/>
                                                    <label class="form-label" for="form3Example5">Password</label>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-12 mb-4 pb-2">
                                                <div class="form-outline">
                                                    <input type="text" name="confirmPassword" id="form3Example6"
                                                           class="form-control form-control-lg"/>
                                                    <label class="form-label" for="form3Example6">Confirm
                                                        Password</label>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <div class="col-lg-6 bg-indigo text-white">
                                    <div class="p-5">
                                        <h3 class="fw-normal mb-5">Contact Details</h3>
                                        <div class="mb-4 pb-2">
                                            <div class="form-outline form-white">
                                                <input type="text" id="form3Examplea2"
                                                       class="form-control form-control-lg"/>
                                                <label class="form-label" for="form3Examplea2">Street + Nr</label>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-5 mb-4 pb-2">
                                                <div class="form-outline form-white">
                                                    <input type="text" id="form3Examplea4"
                                                           class="form-control form-control-lg"/>
                                                    <label class="form-label" for="form3Examplea4">Zip Code</label>
                                                </div>

                                            </div>
                                            <div class="col-md-7 mb-4 pb-2">

                                                <div class="form-outline form-white">
                                                    <input type="text" id="form3Examplea5"
                                                           class="form-control form-control-lg"/>
                                                    <label class="form-label" for="form3Examplea5">City</label>
                                                </div>

                                            </div>
                                        </div>

                                        <div class="mb-4 pb-2">
                                            <div class="form-outline form-white">
                                                <input type="text" id="form3Examplea6"
                                                       class="form-control form-control-lg"/>
                                                <label class="form-label" for="form3Examplea6">Country</label>
                                            </div>
                                        </div>

                                        <div class="mb-4">
                                            <div class="form-outline form-white">
                                                <input type="text" name="email" id="form3Examplea9"
                                                       class="form-control form-control-lg"/>
                                                <label class="form-label" for="form3Examplea9">Your Email</label>
                                            </div>
                                        </div>


                                        <button type="submit" class="btn btn-light btn-lg" data-mdb-ripple-color="dark">
                                            Register
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
</body>
</html>
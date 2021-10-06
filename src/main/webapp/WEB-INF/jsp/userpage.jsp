<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>

<!doctype html>
<html lang="en">
<head>
    <jsp:include page="headerPage.jsp"/>
</head>

<body>
<jsp:include page="navbar.jsp"></jsp:include>

<div class="pricing-header px-3 py-3 pt-md-5 pb-md-4 mx-auto text-center">
    <h1 class="display-4">Red balloons shop111111</h1>
    <h1>${sessionUser.name}</h1>
    <p class="lead">Some text.</p>
</div>

<div class="container">
    <div class="card-deck mb-3 text-center">
        <div class="card mb-4 box-shadow">
            <div class="card-header">
                <h4 class="my-0 font-weight-normal">Balloon 18</h4>
            </div>
            <div class="card-body">
                <h1 class="card-title pricing-card-title">$20 <small class="text-muted">/ unit</small></h1>
                <ul class="list-unstyled mt-3 mb-4">
                    <li>diameter 18</li>
                    <li>some description</li>
                    <li>some description</li>
                    <li>some description</li>
                </ul>
                <button type="button" class="btn btn-lg btn-block btn-primary">Add to cart</button>
            </div>
        </div>
        <div class="card mb-4 box-shadow">
            <div class="card-header">
                <h4 class="my-0 font-weight-normal">Balloon 19</h4>
            </div>
            <div class="card-body">
                <h1 class="card-title pricing-card-title">$22 <small class="text-muted">/ unit</small></h1>
                <ul class="list-unstyled mt-3 mb-4">
                    <li>diameter 19</li>
                    <li>some description</li>
                    <li>some description</li>
                    <li>some description</li>
                </ul>
                <button type="button" class="btn btn-lg btn-block btn-primary">Add to cart</button>
            </div>
        </div>
        <div class="card mb-4 box-shadow">
            <div class="card-header">
                <h4 class="my-0 font-weight-normal">Balloon 20</h4>
            </div>
            <div class="card-body">
                <h1 class="card-title pricing-card-title">$24 <small class="text-muted">/ unit</small></h1>
                <ul class="list-unstyled mt-3 mb-4">
                    <li>diameter 20</li>
                    <li>some description</li>
                    <li>some description</li>
                    <li>some description</li>
                </ul>
                <button type="button" class="btn btn-lg btn-block btn-primary">Add to cart</button>
            </div>
        </div>

    </div>
    <div class="card-deck mb-3 text-center">
        <div class="card mb-4 box-shadow">
            <div class="card-header">
                <h4 class="my-0 font-weight-normal">Balloon 21</h4>
            </div>
            <div class="card-body">
                <h1 class="card-title pricing-card-title">$26 <small class="text-muted">/ unit</small></h1>
                <ul class="list-unstyled mt-3 mb-4">
                    <li>diameter 21</li>
                    <li>some description</li>
                    <li>some description</li>
                    <li>some description</li>
                </ul>
                <button type="button" class="btn btn-lg btn-block btn-primary">Add to cart</button>
            </div>
        </div>
        <div class="card mb-4 box-shadow">
            <div class="card-header">
                <h4 class="my-0 font-weight-normal">Balloon 22</h4>
            </div>
            <div class="card-body">
                <h1 class="card-title pricing-card-title">$28 <small class="text-muted">/ unit</small></h1>
                <ul class="list-unstyled mt-3 mb-4">
                    <li>diameter 22</li>
                    <li>some description</li>
                    <li>some description</li>
                    <li>some description</li>
                </ul>
                <button type="button" class="btn btn-lg btn-block btn-primary">Add to cart</button>
            </div>
        </div>
        <div class="card mb-4 box-shadow">
            <div class="card-header">
                <h4 class="my-0 font-weight-normal">Balloon 23</h4>
            </div>
            <div class="card-body">
                <h1 class="card-title pricing-card-title">$30 <small class="text-muted">/ unit</small></h1>
                <ul class="list-unstyled mt-3 mb-4">
                    <li>diameter 23</li>
                    <li>some description</li>
                    <li>some description</li>
                    <li>some description</li>
                </ul>
                <button type="button" class="btn btn-lg btn-block btn-primary">Add to cart</button>
            </div>
        </div>

    </div>
</div>

<footer class="pt-4 my-md-5 pt-md-5 border-top">
    <div class="row">
        <div class="col-12 col-md">
            <img class="mb-2" src="https://getbootstrap.com/docs/4.0/assets/brand/bootstrap-solid.svg" alt=""
                 width="24" height="24">
            <small class="d-block mb-3 text-muted">&copy; 2017-2018</small>
        </div>
        <div class="col-6 col-md">
            <h5>Features</h5>
            <ul class="list-unstyled text-small">
                <li><a class="text-muted" href="#">Cool stuff</a></li>
                <li><a class="text-muted" href="#">Random feature</a></li>
                <li><a class="text-muted" href="#">Team feature</a></li>
                <li><a class="text-muted" href="#">Stuff for developers</a></li>
                <li><a class="text-muted" href="#">Another one</a></li>
                <li><a class="text-muted" href="#">Last time</a></li>
            </ul>
        </div>
        <div class="col-6 col-md">
            <h5>Resources</h5>
            <ul class="list-unstyled text-small">
                <li><a class="text-muted" href="#">Resource</a></li>
                <li><a class="text-muted" href="#">Resource name</a></li>
                <li><a class="text-muted" href="#">Another resource</a></li>
                <li><a class="text-muted" href="#">Final resource</a></li>
            </ul>
        </div>
        <div class="col-6 col-md">
            <h5>About</h5>
            <ul class="list-unstyled text-small">
                <li><a class="text-muted" href="#">Team</a></li>
                <li><a class="text-muted" href="#">Locations</a></li>
                <li><a class="text-muted" href="#">Privacy</a></li>
                <li><a class="text-muted" href="#">Terms</a></li>
            </ul>
        </div>
    </div>
</footer>
</div>
</body>
</html>

<%-- 
    Document   : navbar
    Created on : Mar 11, 2021, 3:37:57 PM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>
        <!-- Font Awesome -->
        <link
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css"
            rel="stylesheet"
            />
        <!-- Google Fonts -->
        <link
            href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap"
            rel="stylesheet"
            />
        <!-- MDB -->
        <link
            href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/3.3.0/mdb.min.css"
            rel="stylesheet"
            />
    </head>
    <body>
        <!-- Navbar -->
        <nav class="navbar navbar-expand-md navbar-light">

            <a style="margin-left: 50px;" class="navbar-brand" href="#!">
                <img src="https://mdbootstrap.com/img/logo/mdb-transaprent-noshadows.png" height="30" alt="mdb logo">
            </a>

            <!-- Collapse button -->
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#basicExampleNav13"
                    aria-controls="basicExampleNav13" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <!-- Links -->
            <div class="collapse navbar-collapse" id="basicExampleNav13">

                <form style="margin-left: 500px; margin-right: 200px;" class="navbar-search pl-0 ml-auto mt-3 mb-2 mt-md-0 mb-md-0 mr-3" action="">
                    <div class="input-group d-block d-md-flex mb-0">
                        <div class="input-group-prepend">
                            <a href="#!" class="input-icon d-flex align-items-center" type="button"><i
                                    class="fas fa-search text-white mx-3"></i></a>
                            <input style="width: 500px; margin-top: -20px;" class="form-control white-text rgba-black-light border-0 z-depth-0 pl-5" type="text"
                                   placeholder="Search" aria-label="Search">
                        </div>
                    </div>
                </form>

                <!-- Right -->
                <ul class="navbar-nav">
                    <li style="margin-right: 20px;" class="nav-item">
                        <a href="#!" class="nav-link navbar-link-2 waves-effect">
                            <span class="badge badge-pill red">1</span>
                            <i class="fas fa-shopping-cart pl-0"></i>
                        </a>
                    </li>
                    <li class="nav-item dropdown">  
                        <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownMenuLink">
                            <a class="dropdown-item" href="#!">Action</a>
                            <a class="dropdown-item" href="#!">Another action</a>
                            <a class="dropdown-item" href="#!">Something else here</a>
                        </div>
                    </li>
                    <li style="margin-right: 20px;" class="nav-item">
                        <a href="#!" class="nav-link waves-effect">
                            Home
                        </a>
                    </li>
                    <li style="margin-right: 20px;" class="nav-item">
                        <a href="#!" class="nav-link waves-effect">
                            Contact
                        </a>
                    </li>
                    <li style="margin-right: 20px;" class="nav-item d-md-none d-xl-inline-block">
                        <a href="#!" class="nav-link waves-effect">
                            Sign in
                        </a>
                    </li>
                    <li style="margin-right: 60px;" class="nav-item pl-2 mb-2 mb-md-0 d-md-none d-xl-inline-block">
                        <a href="#!" type="button"
                           class="btn btn-outline-info btn-md btn-rounded btn-navbar waves-effect waves-light">Sign
                            up</a>
                    </li>
                </ul>

            </div>
            <!-- Links -->

        </nav>
        <!-- Navbar -->
    </body>
</html>

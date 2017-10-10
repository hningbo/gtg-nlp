<%@ page language="java" contentType="text/html; charset=utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <%@ page isELIgnored="false"%>
            <!DOCTYPE html>
            <html lang="en">

            <head>
                <meta charset="utf-8">
                <meta http-equiv="X-UA-Compatible" content="IE=edge">
                <meta name="viewport" content="width=device-width, initial-scale=1">
                <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
                <meta name="description" content="gtg-nlp">
                <meta name="author" content="rylynn">
                <link rel="icon" href="/favicon.ico">
                <title>gtg-nlp</title>
                <!-- Bootstrap core CSS -->
                <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
                <!-- Custom styles for this template -->
                <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
                <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]--
        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
                <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
            </head>

            <body>
                <nav class="navbar navbar-inverse navbar-fixed-top">
                    <div class="container">
                        <div class="navbar-header">
                            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                                <span class="sr-only">Toggle navigation</span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                            </button>
                            <a class="navbar-brand" href="#">GTG</a>
                        </div>
                        <div id="navbar" class="collapse navbar-collapse">
                            <ul class="nav navbar-nav">
                                <li class="active"><a href="#">Home</a></li>
                                <li><a href="#about">About</a></li>
                                <li><a href="#contact">Contact</a></li>
                            </ul>
                        </div>
                        <!--/.nav-collapse -->
                    </div>
                </nav>
                <div class="container">
                    <h4>zhan</h4>
                    <div class="container-fluid">
                        <div class="row">
                            <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <h3 class="panel-title">自然语言处理模块</h3>
                                    </div>
                                    <div class="panel-body">
                                        采用Stanford CoreNLP对非结构化的自然语言进行抽取
                                    </div>
                                </div>
                            </div>
                            <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <h3 class="panel-title">自然语言处理:</h3>
                                    </div>
                                    <div class="panel-body">
                                        <form action="nlp.do" name="nlpform" method="POST">
                                            <legend>请在此输入文本:</legend>
                                            <div class="form-group">
                                                <textarea name="content" class="form-control" rows="8" placeholder="输入您要分析的文段"></textarea>
                                            </div>
                                            <button type="submit" class="btn btn-primary">提交</button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                                
                            <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <h3 class="panel-title">分析结果为:</h3>
                                    </div>
                                    <div class="panel-body">
                                        <table class="table table-hover">
                                            <thead>
                                                <tr>
                                                    <th>Dependency Trees</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                            <c:forEach item="${dependencies}" var="d">
                                                <tr>
                                                    <td>${d}</td>
                                                </tr>
                                            </tbody>
                                        </table>
                                        <form action="nlp-save.do" method="POST" role="form">
                                            <legend>请在下面输入框中修改不正确结果:</legend>
                                            <div class="form-group">
                                                <table class="table">
                                                    <thead>
                                                        <tr>
                                                            <td>Subject</td>
                                                            <td>Predicate</td>
                                                            <td>Object</td>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <c:forEach items="${claims}" var="c" varStatus="status">
                                                            <tr>
                                                                <td>
                                                                    <input type="text" name="claim[${status.count-1}].subject" class="form-control" value="${c.subject}">
                                                                </td>
                                                                <td>
                                                                    <input type="text" name="claim[${status.count-1}].predicate" class="form-control" value="${c.predicate}">
                                                                </td>
                                                                <td>
                                                                    <input type="text" name="claim[${status.count-1}].object" class="form-control" value="${c.object}">
                                                                </td>
                                                            </tr>
                                                        </c:forEach>
                                                    </tbody>
                                                </table>
                                            </div>
                                            <button type="submit" class="btn btn-primary">保存至数据库</button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                </div>
                <!-- /.container -->
                <!-- Bootstrap core JavaScript
    ================================================== -->
                <!-- Placed at the end of the document so the pages load faster -->
                <script>
                $(function() { $('#myModal').modal('hide') });
                </script>
                <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
                <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
                <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
                <script src="http://getbootstrap.com/assets/js/ie10-viewport-bug-workaround.js"></script>
            </body>

            </html>
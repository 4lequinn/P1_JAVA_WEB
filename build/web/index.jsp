<%-- 
    Document   : index
    Created on : 13-09-2021, 17:58:45
    Author     : Sammy Guergachi <sguergachi at gmail.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<link rel="stylesheet" href="static/css/base.css">
<html>
    <head>
        <%@include file="base_bar.jsp" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="static/js/card.js"></script>
        <title>Home</title>
    </head>
    <body style="overflow: scroll">
        
 
    <div class="home_content">
        <div class="text-center mt-4">
            <h2 style="color: #fff">Video Juego</h2>
        </div>
        <article id="slider">
            <input checked type='radio' name='slider' id='slide1'/>
            <input type='radio' name='slider' id='slide2'/>
            <input type='radio' name='slider' id='slide3'/>
            <input type='radio' name='slider' id='slide4'/>
            <input type='radio' name='slider' id='slide5'/>
            <div id="slides">
                <div id="container">
                    <div class="inner">
                        <article>
                            <div class='caption'>
                                <bar>League of Legends <a href="#">Información</a></bar>
                            </div>
                            <img src="https://cdn.hobbyconsolas.com/sites/navi.axelspringer.es/public/styles/1200/public/media/image/2020/10/league-legends-2113595.jpg?itok=i0lLAKp6"/>
                        </article>
                        <article>
                            <div class='caption'>
                                <bar>Counter Strike GO <a href="#">Información</a></bar>
                            </div>
                            <img src="https://as.com/meristation/imagenes/2021/06/05/noticias/1622881757_363299_1622881817_noticia_normal.jpg"/>
                        </article>
                        <article>
                            <div class='caption'>
                                <bar>Fortnite <a href="#">Información</a></bar>
                            </div>
                            <img src="https://cdn2.unrealengine.com/14br-consoles-1920x1080-wlogo-1920x1080-432974386.jpg"/>
                        </article>
                        <article>
                            <div class='caption'>
                                <bar>Warzone <a href="#">Información</a></bar>
                            </div>
                            <img src="https://as.com/meristation/imagenes/2020/03/09/noticias/1583775131_472069_1583777131_noticia_normal.jpg"/>
                        </article>
                        <article>
                            <div class='caption'>
                                <bar>Battlefield 4 <a href="#">Información</a></bar>
                            </div>
                            <img src="https://cdn-ext.fanatical.com/production/product/1280x720/b2f8db85-de7b-4465-9745-5c735b8f6562.jpeg"/>
                        </article>
                    </div>
                </div>
            </div>
            <div id="commands">
                <label for='slide1'></label>
                <label for='slide2'></label>
                <label for='slide3'></label>
                <label for='slide4'></label>
                <label for='slide5'></label>
            </div>
            <div id="active">
                <label for='slide1'></label>
                <label for='slide2'></label>
                <label for='slide3'></label>
                <label for='slide4'></label>
                <label for='slide5'></label>
            </div>
        </article>
        <ul class="card-list">
            <li class="card">
                <a class="card-image" href="liga.jsp" target="_blank" style="background-image: url(https://as.com/meristation/imagenes/2020/03/09/noticias/1583775131_472069_1583777131_noticia_normal.jpg);" data-image-full="https://as.com/meristation/imagenes/2020/03/09/noticias/1583775131_472069_1583777131_noticia_normal.jpg">
                    <img src="https://as.com/meristation/imagenes/2020/03/09/noticias/1583775131_472069_1583777131_noticia_normal.jpg" alt="Psychopomp" />
                </a>
                <a class="card-description" href="https://michellezauner.bandcamp.com/album/psychopomp-2" target="_blank">
                    <h2>Warzone</h2>
                    <p>Unete</p>
                </a>
            </li>
            <li class="card">
                <a class="card-image" href="liga.jsp" target="_blank" style="background-image: url(https://as.com/meristation/imagenes/2021/06/05/noticias/1622881757_363299_1622881817_noticia_normal.jpg);" data-image-full="https://as.com/meristation/imagenes/2021/06/05/noticias/1622881757_363299_1622881817_noticia_normal.jpg">
                    <img src="https://as.com/meristation/imagenes/2021/06/05/noticias/1622881757_363299_1622881817_noticia_normal.jpg" alt="let's go" />
                </a>
                <a class="card-description" href="https://inlovewithaghost.bandcamp.com/album/lets-go" target="_blank">
                    <h2>Counter Strike GO</h2>
                    <p>Unete</p>
                </a>
            </li>
            <li class="card">
                <a class="card-image" href="liga.jsp" target="_blank" style="background-image: url(https://cdn.hobbyconsolas.com/sites/navi.axelspringer.es/public/styles/1200/public/media/image/2020/10/league-legends-2113595.jpg?itok=i0lLAKp6);" data-image-full="https://cdn.hobbyconsolas.com/sites/navi.axelspringer.es/public/styles/1200/public/media/image/2020/10/league-legends-2113595.jpg?itok=i0lLAKp6">
                    <img src="https://cdn.hobbyconsolas.com/sites/navi.axelspringer.es/public/styles/1200/public/media/image/2020/10/league-legends-2113595.jpg?itok=i0lLAKp6" alt="Jane Doe" />
                </a>
                <a class="card-description" href="https://convergecult.bandcamp.com/album/jane-doe" target="_blank">
                    <h2>League of Legends</h2>
                    <p>Unete</p>
                </a>
            </li>
        </ul>
        <script src="static/js/slider.js"></script>
        
        <%@include file="base_footer.jsp" %>
    </div>
    <link rel="stylesheet" href="static/css/index.css">
       </body>
</html>

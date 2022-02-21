<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Gowun+Dodum&display=swap" rel="stylesheet">
    
    
	<link href="../resources/css/mainpage.css" rel="stylesheet" type="text/css">
	<link href="../resources/css/header.css" rel="stylesheet" type="text/css">
	<link href="../resources/css/footer.css" rel="stylesheet" type="text/css">
	
	<!-- <script src="../resources/js/mainpage.js"></script> -->
	<script src="../resources/js/header.js"></script>
	

</head>
<body>

<%@ include file="../Header&Footer/header.jsp" %>

	<div class="wrap">

		
		<div id="container">
		           <!-- 본문1 -->
		    <div class="main1">
		    
		        <div class="msImg">
		            <a href="#"><img src="../resources/img/tea_time1.jpg" class="magazine"></a>
		        </div><!--msImg-->
		
		        <div class="msPager">
		            <ul>
		                <li><a href="https://www.osulloc.com/kr/ko/about/osulloc">일구다<br>가꾸다</a></li>
		                <li><a href="https://www.osulloc.com/kr/ko/about/since1979">Since<br> 1979</a></li>
		                <li><a href="https://www.osulloc.com/kr/ko/about/terroir">오설록<br> 차밭</a></li>
		                <li><a href="https://www.osulloc.com/kr/ko/about/by_numbers">숫자로보는<br>오설록</a></li>
		                <li class="on"><a href="https://www.osulloc.com/kr/ko/shop/item/teahouse">차<br>하우스</a></li>
		            </ul>
		        </div>
		    </div><!--.mainSlide-->
		
		    <!-- 본문2 -->
		    <section class="main2">
		        <h2>차 알아보기</h2>
		        <ul>
		            <li class="tea1">
		                <a href="#">
		                    <p class="over">
		                        <span>명차</span>
		                    </p>
		                </a>
		            </li>
		            <li class="tea2">
		                <a href="#">
		                    <p class="over">
		                        <span>녹차/발효차/홍차</span>
		                    </p>
		                </a>
		            </li>
		            <li class="tea3">
		                <a href="#">
		                    <p class="over">
		                        <span>건강차</span>
		                    </p>
		                </a>
		            </li>
		            <li class="tea4">
		                <a href="#">
		                    <p class="over">
		                        <span>꽃/과일차</span>
		                    </p>
		                </a>
		            </li>
		        </ul>
		    </section><!--.main2-->
		
		    <section class="main3">
		        <h2 class="m3_title"><a href="#">▽</a> 나만의 맞춤제품</h2>
		        
		        <form id="actionForm" action="/osulloc/page/mainpage" method="get"> 
			        <div class="taste">
			            <select name="kind" id="" class="t_kind">
			                <option value="">종류</option>
			                <option value="명차">명차</option>
			                <option value="녹차">녹차</option>
			                <option value="홍차">홍차</option>
			                <option value="발효차">발효차</option>
			                <option value="건강차">건강차</option>
			                <option value="꽃/과일차">꽃/과일차</option>
			                <option value="뷰티">뷰티</option>
			            </select>
			            <select name="scent" id="" class="t_scent">
			                <option value="">향</option>
			                <option value="달달한향">달달한향</option>
			                <option value="상큼한향">상큼한향</option>
			                <option value="고소한향">고소한향</option>
			                <option value="꽃향">꽃향</option>
			                <option value="과일향">과일향</option>
			            </select>
			            <select name="type" id="" class="t_product">
			                <option value="">상품타입</option>
			                <option value="단품">단품</option>
			                <option value="세트">세트</option>
			            </select>
			            <div class="checkbox">
			                <div class="color">
			                    <input type="checkbox" name="color" id="red" value="red">
			                    <label for="red" class="color_red"></label>
			                </div>
			                <div class="color">
			                    <input type="checkbox" name="color" id="orange" value="orange">
			                    <label for="orange" class="color_orange"></label>
			                </div>
			                <div class="color">
			                    <input type="checkbox" name="color" id="yellow" value="yellow">
			                    <label for="yellow" class="color_yellow"></label>
			                </div>
			                <div class="color">
			                    <input type="checkbox" name="color" id="green" value="green">
			                    <label for="green" class="color_green"></label>
			                </div>
			                <div class="color">
			                    <input type="checkbox" name="color" id="blue" value="blue">
			                    <label for="blue" class="color_blue"></label>
			                </div>
			                <div class="color">
			                    <input type="checkbox" name="color" id="purple" value="purple">
			                    <label for="purple" class="color_purple"></label>
			                </div>
			                <div class="color">
			                    <input type="checkbox" name="color" id="black" value="black">
			                    <label for="black" class="color_black"></label>
			                </div>
			            </div>
			            
			            <div><input type="submit" value="검색" id="proSubmit"></div>
			        </div><!--.taste-->
		        </form>
		
		        <div class="m3_item">
		            <ul>
		            	<c:forEach items="${product}" var="product">
			                <li>
			                    <div class="m3_item_box">
			                        <p class="m3_ib_img">
			                            <a href=""><img src="../resources/img/웨딩그린티 10입(피라미드).png" alt=""></a>
			                        </p>
			                        <p class="m3_ib_name"><a href="">${product.name}</a></p>
			                        <p class="m3_ib_prise">${product.price}원</p>
			                    </div>
			                    <div class="num_cart">
			                        <form action="">
			                            <select name="number" id="">
			                                <option value="1" selected="select">1</option>
			                                <option value="2">2</option>
			                                <option value="3">3</option>
			                                <option value="4">4</option>
			                                <option value="5">5</option>
			                                <option value="6">6</option>
			                                <option value="7">7</option>
			                                <option value="8">8</option>
			                                <option value="9">9</option>
			                                <option value="10">10</option>
			                            </select>
			                            <p><input type="button" value="장바구니" name="cart" id="cart"></p>
			                        </form>
			                    </div>
			                </li>
		                </c:forEach>
		            </ul>
		        </div><!--item-->
		        
		        <div class="main3_a">
		            <div class="main3_l">
		                <a href="#">왼쪽으로 가기</a> 
		            </div>
		            <div class="main3_r">
		                <a href="#">오른쪽으로 가기</a> 
		            </div>
		        </div>
		    </section><!--.main3-->
		
		    <section class="main4">
		        <h2 class="m4_title"><a href="#">▽</a> 이번주 할인상품</h2>
		        <div class="m4_item">
		            <ul>
		                <li>
		                    <div class="m4_item_box">
		                        <p class="m4_ib_img">
		                            <a href=""><img src="../resources/img/제주얼그레이.png" alt=""></a>
		                        </p>
		                        <p class="m4_ib_name"><a href=""> 제주 얼그레이 20입</a></p>
		                        <p>
		                            <span class="m4_ib_prise_d">7040원</span> &nbsp;
		                            <span class="m4_ib_prise">8800원</span>
		                        </p>
		                    </div>
		                    <div class="num_cart">
		                        <form action="">
		                            <select name="number" id="">
		                                <option value="1" selected="select">1</option>
		                                <option value="2">2</option>
		                                <option value="3">3</option>
		                                <option value="4">4</option>
		                                <option value="5">5</option>
		                                <option value="6">6</option>
		                                <option value="7">7</option>
		                                <option value="8">8</option>
		                                <option value="9">9</option>
		                                <option value="10">10</option>
		                            </select>
		                            <p><input type="button" value="장바구니" id="cart"></p>
		                        </form>
		                    </div>
		                </li>
		                <li>
		                    <div class="m4_item_box">
		                        <p class="m4_ib_img">
		                            <a href=""><img src="../resources/img/제주화산암차.png" alt=""></a>
		                        </p>
		                        <p class="m4_ib_name"><a href=""> 제주화산암차 10입</a></p>
		                        <p>                                    
		                            <span class="m4_ib_prise_d">12000원</span> &nbsp;
		                            <span class="m4_ib_prise">15000원</span>
		                        </p>                             
		                    </div>
		                    <div class="num_cart">
		                        <form action="">
		                            <select name="" id="">
		                                <option value="1" selected="select">1</option>
		                                <option value="2">2</option>
		                                <option value="3">3</option>
		                                <option value="4">4</option>
		                                <option value="5">5</option>
		                                <option value="6">6</option>
		                                <option value="7">7</option>
		                                <option value="8">8</option>
		                                <option value="9">9</option>
		                                <option value="10">10</option>
		                            </select>
		                            <p><input type="button" value="장바구니" id="cart"></p>
		                        </form>
		                    </div>
		                </li>
		                <li>
		                    <div class="m4_item_box">
		                        <p class="m4_ib_img">
		                            <a href=""><img src="../resources/img/달빛걷기.png" alt=""></a>
		                        </p>
		                        <p class="m4_ib_name"><a href=""> 달빛걷기 10입</a></p>
		                        <p>                                    
		                            <span class="m4_ib_prise_d">12000원</span> &nbsp;
		                            <span class="m4_ib_prise">15000원</span>
		                        </p>
		                    </div>
		                    <div class="num_cart">
		                        <form action="">
		                            <select name="" id="">
		                                <option value="1" selected="select">1</option>
		                                <option value="2">2</option>
		                                <option value="3">3</option>
		                                <option value="4">4</option>
		                                <option value="5">5</option>
		                                <option value="6">6</option>
		                                <option value="7">7</option>
		                                <option value="8">8</option>
		                                <option value="9">9</option>
		                                <option value="10">10</option>
		                            </select>
		                            <p><input type="button" value="장바구니" id="cart"></p>
		                        </form>
		                    </div>
		                </li>
		                <li>
		                    <div class="m4_item_box">
		                        <p class="m4_ib_img">
		                            <a href=""><img src="../resources/img/삼다연.png" alt=""></a>
		                        </p>
		                        <p class="m4_ib_name"><a href="">삼다연 10입</a></p>
		                        <p>
		                            <span class="m4_ib_prise_d">12000원</span> &nbsp;
		                            <span class="m4_ib_prise">15000원</span>                                   
		                        </p>
		                    </div>
		                    <div class="num_cart">
		                        <form action="">
		                            <select name="" id="">
		                                <option value="1" selected="select">1</option>
		                                <option value="2">2</option>
		                                <option value="3">3</option>
		                                <option value="4">4</option>
		                                <option value="5">5</option>
		                                <option value="6">6</option>
		                                <option value="7">7</option>
		                                <option value="8">8</option>
		                                <option value="9">9</option>
		                                <option value="10">10</option>
		                            </select>
		                            <p><input type="button" value="장바구니"></p>
		                        </form>
		                    </div>
		                </li>
		            </ul>
		        </div><!--m4_item-->
		        <div class="main4_a">
		            <div class="main4_l">
		                <a href="#">왼쪽으로 가기</a> 
		            </div>
		            <div class="main4_r">
		                <a href="#">오른쪽으로 가기</a> 
		            </div>
		        </div>
		    </section><!--.main4-->
		</div><!--#container-->
		
	</div>
	
	<script src="../resources/js/mainpage.js"></script>
	
</body>

<%@ include file="../Header&Footer/footer.jsp" %>
</html>
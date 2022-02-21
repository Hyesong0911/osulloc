<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<div class="wrap">
		<div class="header">
            <div class="headerIn">
                <div class="logo"><a href="/osulloc/page/mainpage">로고1</a></div><!--.logo-->
                <div class="gnb">
                    <ul>
                        <li><a href="#">오설록</a></li>
                        <li><a href="https://www.osulloc.com/kr/ko/shop/item/list?category=teashop">차</a></li>
                        <li><a href="https://www.osulloc.com/kr/ko/shop/teawareshop/use">차용품</a></li>
                        <li><a href="https://www.osulloc.com/kr/ko/shop/item/list?category=bakery">다과</a></li>
                        <li><a href="https://www.osulloc.com/kr/ko/shop/item/list?category=themashop">테마샵</a></li>
                        <li><a href="/osulloc/page/subpage">매거진</a></li>
                    </ul>
                </div><!--.gnb-->

                <div class="member" method="POST">
       		<div class="welcome">
               <c:if test="${login != null }">
					<p>${login.id}님 환영 합니다.</p>
					<input id="logout" type="button" onclick="location.href='/osulloc/member/logout'" value="로그아웃"></input></c:if>
			</div>
           <ul>
               <c:if test="${login == null}"><li><a href="/osulloc/member/login">로그인</a></li></c:if>
               <li><a href="/osulloc/page/cartPage">장바구니</a></li>
               <li><a href="#">언어</a></li>
           </ul>
       </div><!--.member-->

                <div class="search">
                    <input type="text"  >
                    <a href="#">검색창</a>
                </div><!--.search-->
            </div><!--.headerIn-->

            <div class="menus">
                <div class="menu1">
                    <ul>
                        <li>a</li>
                        <li>a</li>
                    </ul>
                </div>
    
                <div class="menu2">
                    <ul>
                        <li>b</li>
                        <li>b</li>
                    </ul>
                </div>
    
                <div class="menu3">
                    <ul>
                        <li>c</li>
                        <li>c</li>
                    </ul>
                </div>
    
                <div class="menu4">
                    <ul>
                        <li>d</li>
                        <li>d</li>
                    </ul>
                </div>
    
                <div class="menu5">
                    <ul>
                        <li>e</li>
                        <li>e</li>
                    </ul>
                </div>
    
                <div class="menu6">
                    <ul>
                        <li>f</li>
                        <li>f</li>
                    </ul>
                </div>
            </div>

            
        </div><!--.header-->
	</div>
        

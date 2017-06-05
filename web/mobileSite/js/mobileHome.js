/**
 * Created by Administrator on 2016/10/13.
 */
window.onload=function(){
/*    console.log("windowonload");*/
}
/*APP*/
//创建模块和控制器
var luckApp = angular.module('luckApp',['ngRoute']);
luckApp.config(['$routeProvider',function($routeProvider){
    $routeProvider
        .when('/',{templateUrl:'views/home.html'})
        .when('/carInfo',{templateUrl:'views/carResource.html'})
        .when('/goodsInfo',{templateUrl:'views/goodsResource.html'})
        .when('/mine',{templateUrl:'views/basicInfo.html'})
        .when('/register',{templateUrl:'views/register.html'})
        .when('/ownerRegister',{templateUrl:'views/ownerRegister.html'})
        .when('/shipperRegister',{templateUrl:'views/shipperRegister.html'})
        .when('/releaseCar',{templateUrl:'views/releaseCar.html'})
        .when('/releaseGoods',{templateUrl:'views/releaseGoods.html'})
        .when('/my',{templateUrl:'views/mine.html'})
        .otherwise({redirectTo:'/'})
}]);

luckApp.controller('luckController',['$scope','$http',function($scope,$http){
    $http
        .get('getCarInfo.do')
        .success(function(response){
           $scope.carInfo = response;

        });
    $http
        .get('getGoodsInfo.do')
        .success(function(goods){
            $scope.goodsInfo = goods;
        });

}]).controller('loginController' , ['$scope' , function($scope) {

}]).controller('registerController' , ['$scope' , function($scope){

}]).controller('luckMineController',['$scope','$http',function($scope,$http){
    $http
        .get('mine.do')
        .success(function(response){
            if(response=="0"){
                window.location.href="index.html#/mine";
            }else{
                $scope.currentUserName = response;
            }
        });
}]);

function autoChange(){
    $('.adpic>ul').animate({
        'margin-left':'-20rem'
    },2800,function(e){
        $('ul').css({
            'margin-left':'0px'
        }).children('li').last().after($('ul').children('li').first())
    });
}

setInterval(autoChange,2000);

/*********************************分页***********************************/
function showByPages(){
    $('.currentCarInfo').each(function(){
        var pages = 3;
        var $children = $(this).children();
        if($children.length > pages){
            for(var i = pages;i < $children.length;i++){
                $children.eq(i).hide();
            };
            var lastChild = $(this).children()[$children.length-1];
            $("<div class='showMorehandle'>加载更多…</div>").insertAfter(lastChild).click(function () {
                if (showMoreNChildren($children, pages) <= 0) {
                    //如果目标元素已经没有隐藏的子元素了，就隐藏“点击更多的按钮条”
                    $(this).hide();
                };
            });
        }
    });
}
function showMoreNChildren($children,pages){
    //显示某jquery元素下的前n个隐藏的子元素
    var $hiddenChildren = $children.filter(":hidden");
    var cnt = $hiddenChildren.length;
    for ( var i = 0; i < pages && i < cnt ; i++) {
        $hiddenChildren.eq(i).show();
    }
    return cnt-pages;//返回还剩余的隐藏子元素的数量
}
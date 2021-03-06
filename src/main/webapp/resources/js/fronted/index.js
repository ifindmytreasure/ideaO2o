/**
 * Created by BlueMelancholy on 2019/1/29/029.
 */
$(function () {
    //定义访问后台，获取头条列表以及一级类别列表的url
    var url = '/o2o/fronted/listmainpageinfo';
    //访问后台
    $.getJSON(url, function (data) {
        if (data.success) {
            var headLineList = data.headLineList;
            var swiperHtml = "";
            headLineList.map(function (item, index) {
                swiperHtml += '' + '<div class="swiper-slide img-wrap">'
                    + '<a href="' + item.lineLink
                    + '" external><img class="banner-img" src="' + getImgUrl() + item.lineImg
                    + '" alt="' + item.lineName + '"></a>' + '</div>'
            });
            //将轮播图组赋给前端html控件
            $(".swiper-wrapper").html(swiperHtml);
            //设置轮播图轮换时间为3秒
            $(".swiper-container").swiper({
                autoplay: 3000,
                //用户对轮播图进行操作时，是否自动停止autoplay
                autoplayDisableOnInteraction: false
            });
            //获取后台传递过来的大类列表
            var shopCategoryList = data.shopCategoryList;
            var categoryHtml = '';
            shopCategoryList.map(function (item, index) {
                categoryHtml += ''
                    + '<div class="col-50 shop-classify" data-category='
                    + item.shopCategoryId + '>' + '<div class="word">'
                    + '<p class="shop-title">' + item.shopCategoryName
                    + '</p>' + '<p class="shop-desc">'
                    + item.shopCategoryDesc + '</p>' + '</div>'
                    + '<div class="shop-classify-img-warp">'
                    + '<img class="shop-img" src="' + getImgUrl() + item.shopCategoryImg
                    + '">' + '</div>' + '</div>';
            });
            $(".row").html(categoryHtml);
            //点击我的，则显示侧栏
            $('#me').click(function () {
                $.openPanel("#panel-right-demo");
            })
            $('.row').on('click', '.shop-classify', function (e) {
                var shopCategoryId = e.currentTarget.dataset.category;
                var newUrl = '/o2o/fronted/shoplist?parentId=' + shopCategoryId;
                window.location.href = newUrl;
            });
            $("#person-name").text(data.user.name + "你好!");
        }
    });
});
<html>
    <#include "../common/header.ftl">
    <body>
        <div id="wrapper" class="toggled">
            <#--边栏-->
            <#include "../common/nav.ftl">
            <#--主体内容-->
            <div id="page-content-wrapper">
                <div class="container-fluid">
                    <div class="row clearfix">
                        <div class="col-md-12 column">
                            <table class="table table-bordered table-hover table-condensed">
                                <thead>
                                <tr>
                                    <th>商品id</th>
                                    <th>名称</th>
                                    <th>图片</th>
                                    <th>单价</th>
                                    <th>库存</th>
                                    <th>描述</th>
                                    <th>类目</th>
                                    <th>创建时间</th>
                                    <th>修改时间</th>
                                    <th colspan="2">操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                    <#list productInfoPage.content as productInfo>
                                    <tr>
                                        <th>${productInfo.productId}</th>
                                        <th>${productInfo.productName}</th>
                                        <th><img src="${productInfo.productIcon}" width="100" height="80"/></th>
                                        <th>${productInfo.productPrice}</th>
                                        <th>${productInfo.productStock}</th>
                                        <th>${productInfo.productDescription}</th>
                                        <th>${productInfo.categoryType}</th>
                                        <th>${productInfo.createTime}</th>
                                        <th>${productInfo.updateTime}</th>
                                        <th><a href="/sell/seller/product/index?productId=${productInfo.productId}">修改</a></th>
                                        <th>
                                            <#if productInfo.productStatus !=0>
                                                <a style="color: chartreuse" href="/sell/seller/product/on_sale?productId=${productInfo.productId}">上架</a>
                                                <#else >
                                                <a style="color: crimson" href="/sell/seller/product/off_sale?productId=${productInfo.productId}">下架</a>
                                            </#if>
                                        </th>
                                    </tr>
                                    </#list>
                                </tbody>
                            </table>
                        </div>
                        <div class="col-md-12 column">
                            <ul class="pagination pull-right">

                                <#if currentPage lte 1>
                                    <li class="disabled"><a href="#">上一页</a></li>
                                <#else >
                                    <li><a href="/sell/seller/product/list?page=${currentPage-1}&size=${size}">上一页</a></li>
                                </#if>
                                <#list 1..productInfoPage.getTotalPages() as index>
                                    <#if currentPage==index>
                                        <li class="disabled"><a href="#">${index}</a></li>
                                    <#else>
                                        <li><a href="/sell/seller/product/list?page=${index}&size=${size}">${index}</a></li>
                                    </#if>
                                </#list>
                                <#if currentPage gte productInfoPage.getTotalPages()>
                                    <li class="disabled"><a href="#">下一页</a></li>
                                <#else >
                                    <li><a href="/sell/seller/product/list?page=${currentPage+1}&size=${size}">下一页</a></li>
                                </#if>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
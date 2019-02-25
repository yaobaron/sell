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
                            <th>类目id</th>
                            <th>名称</th>
                            <th>类目类型Type</th>
                            <th>创建时间</th>
                            <th>修改时间</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                                    <#list productCategoryList as productCategory>
                                    <tr>
                                        <th>${productCategory.categoryId}</th>
                                        <th>${productCategory.categoryName}</th>
                                        <th>${productCategory.categoryType}</th>
                                        <th>${productCategory.createTime}</th>
                                        <th>${productCategory.updateTime}</th>
                                        <th><a href="/sell/seller/category/index?categoryId=${productCategory.categoryId}">修改</a></th>
                                    </tr>
                                    </#list>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
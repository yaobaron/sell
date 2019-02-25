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
                        <div class="col-md-8 column">
                            <form role="form" action="/sell/seller/category/save" method="post">
                                <div class="form-group">
                                    <label>名称</label>
                                    <input type="text" class="form-control" name="categoryName" value="${(productCategory.categoryName)!''}" />
                                </div>
                                <div class="form-group">
                                    <label>类目类型</label>
                                    <input type="number" class="form-control" name="categoryType" value="${(productCategory.categoryType)!''}" />
                                </div>
                                <input hidden  type="text" name="categoryId" value="${(productCategory.categoryId)!''}"/>
                                <button type="submit" class="btn btn-default">提交</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
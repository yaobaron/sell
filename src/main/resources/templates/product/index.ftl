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
                            <form role="form" action="/sell/seller/product/save" method="post">
                                <div class="form-group">
                                    <label>名称</label>
                                    <input type="text" class="form-control" name="productName" value="${(productInfo.productName)!''}" />
                                </div>
                                <div class="form-group">
                                    <label>价格</label>
                                    <input type="text" class="form-control" name="productPrice" value="${(productInfo.productPrice)!''}" />
                                </div>
                                <div class="form-group">
                                    <label>库存</label>
                                    <input type="text" class="form-control" name="productStock" value="${(productInfo.productStock)!''}" />
                                </div>
                                <div class="form-group">
                                    <label>描述</label>
                                    <input type="text" class="form-control" name="productDescription" value="${(productInfo.productDescription)!''}" />
                                </div>
                                <div class="form-group">
                                    <label>图片</label><br>
                                    <img src="${(productInfo.productIcon)!''}" width="125" height="100">
                                    <input type="text" class="form-control" name="productIcon" value="${(productInfo.productIcon)!''}" />
                                </div>
                                <div class="form-group">
                                    <label>类目</label>
                                    <select class="form-group" name="categoryType">
                                       <#list productCategoryList as category>
                                           <option value="${category.categoryType}"
                                               <#if (productInfo.categoryType)?? && productInfo.categoryType==category.categoryType>
                                                   selected
                                               </#if>

                                           >${(category.categoryName)!''}</option>
                                       </#list>
                                    </select>
                                </div>
                                <input hidden  type="text" name="productId" value="${(productInfo.productId)!''}"/>
                                <button type="submit" class="btn btn-default">提交</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
<html>
    <#include "../common/header.ftl">
    <body>
        <div class="container">
            <div class="row clearfix">
                <#--基本数据-->
                <div class="col-md-4 column">
                    <table class="table">
                        <thead>
                        <tr>
                            <th>订单id</th>
                            <th>订单总金额</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>${orderDTO.getOrderId()}</td>
                            <td>${orderDTO.getOrderAmount()}</td>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <#--订单详情表数据-->
                <div class="col-md-12 column">
                    <table class="table">
                        <thead>
                        <tr>
                            <th>商品id</th>
                            <th>商品名称</th>
                            <th>价格</th>
                            <th>数量</th>
                            <th>总额</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list orderDTO.getOrderDetailList() as detailList>
                            <tr>
                                <td>${detailList.getOrderId()}</td>
                                <td>${detailList.productName}</td>
                                <td>${detailList.productPrice}</td>
                                <td>${detailList.productQuantity}</td>
                                <td>${detailList.productPrice * detailList.productQuantity}</td>
                            </tr>
                        </#list>
                        </tbody>
                    </table>
                </div>
                <#--订单操作-->
                <div class="col-md-12 column">
                    <#if orderDTO.getOrderStatus()==0>
                        <a href="/sell/seller/order/finish?orderId=${orderDTO.getOrderId()}" type="button" class="btn btn-primary btn-default">完结订单</a>
                        <a href="/sell/seller/order/cancel?orderId=${orderDTO.getOrderId()}" type="button" class="btn btn-default btn-danger">取消订单</a>
                        <#else >
                        <h3 class="text-info">
                            订单${orderDTO.getOrderStatusEnum().message}
                        </h3>
                    </#if>
                </div>
            </div>
        </div>
    </body>
</html>
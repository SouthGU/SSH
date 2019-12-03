$(document).ready(function(){
    $("#dc").click(function(){
        var id = $("#dc").attr("name");
        console.log("dcname:"+id);
        $.ajax({
            url: "/New/news_deleteCategory.action",//指定判断是否关联的action路径
            async: false,
            type: 'post',
            data: {"id": id},//将a值以id名传回后台，成功后将结果封装在data中
            success: function (data) {
                if (data.status == "0") {
                    $.ajax({
                        url: "/New/category_deleteCategory.action",
                        async: false,
                        type: 'post',
                        data: {"id":id},
                    })
                    $("#dc").submit();
                } else {
                    alert("该类型有数据关联，请解除所有新闻数据！");
                }

            }
        })

    });

    $("#uc").click(function(){
        var id = $("#uc").attr("name");
        console.log("ucname:"+id);
        $.ajax({
            url: "/New/category_deleteCategory.action",
            async: false,
            type: 'post',
            data: {"id":id},
        })
        $("#uc").submit();
    })
})

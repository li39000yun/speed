var table;
var editFlag = false;
$(document).ready(function () {
    table = $('#dataTables-example').DataTable({
        responsive: true,
        "columns": [
            {
                "data": null
            },
            {"data": "loginId"},
            {"data": "userName"},
            {"data": "status"},
            {
                "data": "lastLoginTs"
            },
            {
                "data": "uuid",
                "render": function (data, type, full) {
                    return "<div class='rap-btn-actiongroup'>"
                        + "<button id='rap-btn-view' class='btn btn-xs btn-success' data-rel='tooltip' title='查看'><i class='fa fa-search-plus'></i></button>"
                        + "<button id='rap-btn-edit' onclick='edit(\"" + data + "\")' class='btn btn-xs btn-info' data-rel='tooltip' title='编辑'><i class='fa fa-edit'></i></button>"
                        + "<button id='rap-btn-remove' class='btn btn-xs btn-danger' data-rel='tooltip' title='删除'><i class='fa fa-trash-o'></i></button>"
                        + "</div>";
                }
            }
        ],
        "language": {
            "lengthMenu": "每页显示 _MENU_ 条",
            "zeroRecords": "没有找到记录",
            "info": "当前 _PAGE_/ _PAGES_ 页 共_TOTAL_条",
            "infoEmpty": "无记录",
            "infoFiltered": "(从 _MAX_ 条记录过滤)",
            "oPaginate": {
                "sFirst": "首页",
                "sPrevious": "上一页",
                "sNext": "下一页",
                "sLast": "尾页"
            }
        },
        "fnDrawCallback": function () {
            this.api().column(0).nodes().each(function (cell, i) {
                cell.innerHTML = i + 1;
            });
        }
    });
    // 加载列表
    loadList();
    // 绑定默认按钮
    bindDefaultActions();
});

// 加载列表
function loadList() {
    $.ajax({
        url: 'user/getList',
        data: {},
        dataType: 'json',
        success: function (data) {
            //写数据
            table.clear();
            table.rows.add(data);
            table.draw();
        }
    });
}

// 获取对象数据
function getObj(uuid) {
    var url = "user/get/" + uuid;
    $.ajax({
        url: url,
        dataType: 'json',
        success: function (data) {
            setupData(data);
            console.info(data);
            return data;
        }
    });
}

function setupData(obj) {
    $("#userName").val(obj.userName).attr("disabled", true);
    $("#passWord").val(obj.passWord);
    $("#loginId").val(obj.loginId);
    $("#status").val(obj.status);
    $("#uuid").val(obj.uuid);
}

/**
 *编辑方法
 **/
function edit(uuid) {
    var url = "user/get/" + uuid;
    $.ajax({
        url: url,
        dataType: 'json',
        success: function (obj) {
            editFlag = true;
            $("#myModalLabel").text("修改");
            $("#userName").val(obj.userName).attr("disabled", true);
            $("#passWord").val(obj.passWord);
            $("#loginId").val(obj.loginId);
            $("#status").val(obj.status);
            $("#uuid").val(obj.uuid);
            $("#myModal").modal("show");
        }
    });
}

/**
 * 添加数据
 **/
function add() {
    var addJson = {
        "userName": $("#userName").val(),
        "passWord": $("#passWord").val(),
        "loginId": $("#loginId").val(),
        "status": $("#status").val(),
        "uuid": $("#uuid").val()
    };

    ajax(addJson);
}

function ajax(obj) {
    var url = "user/save";
    $.ajax({
        url: url,
        data: {
            "userName": obj.userName,
            "passWord": obj.passWord,
            "loginId": obj.loginId,
            "status": obj.status,
            "uuid": obj.uuid
        }, success: function (data) {
            // 加载列表
            loadList();
            //table.ajax.reload();
            $("#myModal").modal("hide");
            $("#myModalLabel").text("新增");
            clear();
            console.log("结果" + data);
        }
    });
}


/**
 * 清除
 */
function clear() {
    $("#myModalLabel").text("修改");
    $("#userName").val(name).attr("disabled", false);
    $("#passWord").val();
    $("#loginId").val();
    $("#status").val();
    $("#uuid").val();
    editFlag = false;
}

function bindDefaultActions() {
    // 打开添加记录页面
    $("#rap-btn-add").bind('click', onAdd);

    // 保存
    $("#save").click(add);
}


function onAdd() {
    edit("我三");
}
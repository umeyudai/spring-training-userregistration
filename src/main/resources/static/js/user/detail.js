'use strict'

jQuery(function ($) {
    $('#btn-update').click(function (event) {
        updateUser();
    });

    $('#btn-delete').click(function (event) {
        deleteUser();
    });
});

function updateUser() {
    var formData = $('#user-detail-form').serializeArray();
    console.log(formData);
    $.ajax({
        type: "PUT",
        cache: false,
        url: '/user/update',
        data: formData,
        dataType: 'json',
    }).done(function (data) {
        alert('ユーザー更新をした');
        window.location.href = '/user/list';
    }).fail(function (jpXHR, textStatus, errorThrown) {
        alert('ユーザー更新に失敗した');
    }).always(function () {

    });
}

function deleteUser() {
    var formData = $('#user-detail-form').serializeArray();

    $.ajax({
        type: "DELETE",
        cache: false,
        url: '/user/delete',
        data: formData,
        dataType: 'json',
    }).done(function (data) {
        alert('ユーザー削除をした');
        window.location.href = '/user/list';
    }).fail(function (jpXHR, textStatus, errorThrown) {
        alert('ユーザー削除に失敗した');
    }).always(function () {

    });
}
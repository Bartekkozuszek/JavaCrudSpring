$('document').ready(function(){

    $('.table #deleteButton').on('click',function(event){
        console.log("JQuery called");
        event.preventDefault();
        var href = $(this).attr('href');
        $.get(href, function (teacher) {
            $('#idDelete').val(teacher.id);
            $('#teacherDelete').text(teacher.name);
        });
        $('#deleteModal').modal();
    });


    $('.table #editButton').on('click',function(event){

        event.preventDefault();

        var href = $(this).attr('href');

        $.get(href, function (teacher, status) {
            $('#idEdit').val(teacher.id);
            $('#nameEdit').val(teacher.name);
            $('#departmentEdit').val(teacher.department);
            $('#updatedByEdit').val(teacher.updatedBy);

        });

        $('#editModal').modal();
    });
});

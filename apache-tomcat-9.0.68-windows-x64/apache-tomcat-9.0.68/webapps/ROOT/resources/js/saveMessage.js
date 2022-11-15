function saveMessage() {
    var textArea = $("#message").val();
    var username = document.querySelector('#username').innerText.trim()
    console.log(username);
    $.ajax({
        url: 'saveMessage',
        method: 'GET',
        dataType: 'json',
        contentType: 'application/json',
        mimeType: 'application/json',
        data: ({
            message: textArea,
            username: username
        }),
        success: console.log("Save message")
    });
}
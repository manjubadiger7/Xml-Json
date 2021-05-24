/**
 * 
 */
var button = document.getElementById("values-btn");
button.addEventListener("click", function() {
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
	if (this.readyState == 4 && this.status == 200) {
	    console.log(this.responseText);
	    var data = JSON.parse(this.responseText);
	    renderHtml(data);
	}
    };
    xhr.open('GET', 'getvalues', true);
    xhr.send();
});
function renderHtml(data) {
    
    let displayRow= ``;
    for (var i = 0; i < data.length; ++i) {
	
	displayRow += `<tr>
	<td>${data[i].personName}</td>
	<td>${data[i].personId}</td>
	<td>${data[i].personAge}</td>
	
	</tr>`;

    }
    display.innerHTML = displayRow;

}

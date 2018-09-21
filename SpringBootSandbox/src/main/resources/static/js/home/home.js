/*
 Created on : Sep 20, 2018, 11:13:12 AM
 Author     : Richard Nader Jr. <heelyskidrj@gmail.com>
 */

$(document).ready(() => {
    console.log("Home page loaded!");
    // For alertify
    $('#alertBtn').on('click', () => {
        alertify.alert("A new alert!", "This is a new alert!");
    });
    $.ajax({
        type: "GET",
        dataType: "json",
        url: contextPath + "users/all",
        success: (data) => {
            // For Datatables
            $('#dataTableExample').DataTable({
                data: data,
                columns: [
                    {data: "userId"},
                    {data: "firstName"},
                    {data: "lastName"},
                    {data: "email"},
                    {data: "gender"},
                    {data: "phone"},
                    {data: "address"},
                    {data: "city"},
                    {data: "state"},
                    {data: "zipcode"}
                ]
            });
        },
        error: (e) => {
            console.log(e);
        }
    });
});
// For chart.js
var ctx = $("#homeChart");
var homeChart = new Chart(ctx, {
    type: 'bar',
    data: {
        labels: ["Red", "Blue", "Yellow", "Green", "Purple", "Orange"],
        datasets: [{
                label: '# of Votes',
                data: [12, 19, 3, 5, 2, 3],
                backgroundColor: [
                    'rgba(255, 99, 132, 0.2)',
                    'rgba(54, 162, 235, 0.2)',
                    'rgba(255, 206, 86, 0.2)',
                    'rgba(75, 192, 192, 0.2)',
                    'rgba(153, 102, 255, 0.2)',
                    'rgba(255, 159, 64, 0.2)'
                ],
                borderColor: [
                    'rgba(255,99,132,1)',
                    'rgba(54, 162, 235, 1)',
                    'rgba(255, 206, 86, 1)',
                    'rgba(75, 192, 192, 1)',
                    'rgba(153, 102, 255, 1)',
                    'rgba(255, 159, 64, 1)'
                ],
                borderWidth: 1
            }]
    },
    options: {
        scales: {
            yAxes: [{
                    ticks: {
                        beginAtZero: true
                    }
                }]
        }
    }
});


map.addPlugin('pieChart', function (layer, data) {
    var self = this;
    var rawData = data.rawData;
    var className = 'pieChart';


    var sum = 0;
    for (var i = 0; i < rawData.length; i++) {
        sum += rawData[i];
    }

    var percentageData = [];
    for (var i = 0; i < rawData.length; i++) {
        percentageData.push(rawData[i] / sum);
    }

    var pieCharts = layer.selectAll(className).data(data, JSON.stringify);


    var pie = "";
    // create the pie chart
    var cumulativePercent = 0;
    function getCoordinatesForPercent(percent) {
        const x = Math.cos(2 * Math.PI * percent);
        const y = Math.sin(2 * Math.PI * percent);
        return [x, y];
    }
    
    

    pieCharts.enter()
            .append();

});

import axios from 'axios';
import { useEffect, useState } from 'react';
import Chart from 'react-apexcharts';
import { SaleSum } from 'types/sale';
import { BASE_URL } from 'utils/requests';

type ChartData = {
    labels: string[];
    series: number[];
}

function DonutChart() {

    //useState
    const [chartData, setChartData] = useState<ChartData>({ labels: [], series: [] });

    //useEffect
    useEffect(() => {
        axios.get(`${BASE_URL}/sales/amount-by-seller`)
            .then(response => {
                const data = response.data as SaleSum[];
                const MyLabels = data.map(x => x.sallerName);
                const MySeries = data.map(x => x.sum);


                setChartData({ labels: MyLabels, series: MySeries });
            });

    }, []);

    const options = {
        legend: {
            show: true
        }
    }

    return (

        <Chart
            options={{ ...options, labels: chartData.labels }}
            series={chartData.series}
            type='donut'
            height='240'
        />
    );

}

export default DonutChart;
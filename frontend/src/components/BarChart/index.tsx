import axios from 'axios';
import { useEffect, useState } from 'react';
import Chart from 'react-apexcharts';
import { SaleSuccess } from 'types/sale';
import { round } from 'utils/format';
import { BASE_URL } from 'utils/requests';

type SeriesData = {
    name: string;
    data: number[];
}

type ChartData = {
    labels: {
        categories: string[];
    }
    series: SeriesData[];

}

function BarChart() {

    //useState
    const [chartData, setChartData] = useState<ChartData>({
        labels: {
            categories: []
        },
        series: [
            {
                name: "% Sucesso",
                data: []
            }
        ]
    });

    //useEffect
    useEffect(() => {
        axios.get(`${BASE_URL}/sales/success-by-seller`)
            .then(response => {
                const data = response.data as SaleSuccess[];
                const MyLabels = data.map(x => x.sallerName);
                const MySeries = data.map(x => round(100 * x.deals / x.visited, 1));


                setChartData({
                    labels: {
                        categories: MyLabels
                    },
                    series: [
                        {
                            name: "% Sucesso",
                            data: MySeries
                        }
                    ]
                });
            });

    }, []);


    const options = {
        plotOptions: {
            bar: {
                horizontal: true,
            }
        }

    };

    return (

        <Chart
            options={{ ...options, xaxis: chartData.labels }}
            series={chartData.series}
            type='bar'
            height='240'
        />
    );

}

export default BarChart;
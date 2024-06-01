import React, { useState, useEffect } from "react";
import { Card, CardContent, Typography } from "@material-ui/core";
import Box from "@mui/material/Box";

function OutsideTemperatureWidget() {
    const [temperature, setTemperature] = useState("30C"); // Set to empty initially
    const [error, setError] = useState(null); // State to track errors

    // useEffect(() => {
    //     const fetchTemperature = () => {
    //         fetch("http://api.openweathermap.org/data/2.5/weather?q=Porto&appid=7d7d3b8f1f0c4c1d1b1b7c9d7d9d7d9d")
    //             .then((response) => response.json())
    //             .then((data) => {
    //                 if (data && data.main && typeof data.main.temp !== 'undefined') {
    //                     setTemperature(`${data.main.temp}ºC`);
    //                 } else {
    //                     throw new Error("Invalid API response structure");
    //                 }
    //             })
    //             .catch((err) => {
    //                 console.error("Error fetching temperature:", err);
    //                 setError("Error fetching temperature");
    //             });
    //     };
    //
    //     // Get the current date and time
    //     const now = new Date();
    //
    //     // Calculate how many milliseconds have passed since the last 15-minute mark
    //     const delay = (15 - (now.getMinutes() % 15)) * 60 * 1000 - now.getSeconds() * 1000 - now.getMilliseconds();
    //
    //     // Fetch the temperature immediately
    //     fetchTemperature();
    //
    //     // Then fetch the temperature every 15 minutes starting at the next 15-minute mark
    //     const timeoutId = setTimeout(() => {
    //         fetchTemperature();
    //         const intervalId = setInterval(fetchTemperature, 15 * 60 * 1000);
    //
    //         // Clear the interval when the component unmounts
    //         return () => clearInterval(intervalId);
    //     }, delay);
    //
    //     // Clear the timeout when the component unmounts
    //     return () => clearTimeout(timeoutId);
    // }, []);

    return (
        <Box>
            <Card style={{
                backgroundColor: 'white', color: 'black',
                display: 'flex', flexDirection: 'column',
                alignItems: 'center', justifyContent: 'center', height: 100
            }}>
                <CardContent>
                    <Typography variant="h6" component="h2">
                        Outside temperature: {error ? error : temperature}
                    </Typography>
                </CardContent>
            </Card>
        </Box>
    );
}

export default OutsideTemperatureWidget;

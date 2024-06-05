import React, {useEffect} from 'react';
import SunriseSunsetWidget from "../components/SunriseSunsetWidget";
import OutsideTemperatureWidget from "../components/OutsideTemperatureWidget";
import Header from "../components/Header";
import RoomsList from "../components/RoomsList";
import './MainPage.css';
import {fetchCurrentPositionValue} from "../services/Service.jsx";

function MainPage() {

/*    useEffect(() => {
        fetchCurrentPositionValue('yourTestDeviceID').then(data => {
            console.log("Test fetch:", data);
        }).catch(error => {
            console.error("Test fetch error:", error);
        });
    }, []);
    */


    return (
        <div className="main-page">
            <Header/>
            <div className="main-page-body">
                <div className="rooms-container">
                    <h3 className="rooms-container-header">Rooms</h3>
                    <RoomsList/>
                </div>
                <div className="main-page-body-widgets">
                    <div className="widget">
                        <OutsideTemperatureWidget/>
                    </div>
                    <div className="widget">
                        <SunriseSunsetWidget/>
                    </div>
                </div>
            </div>
            <div className="main-page-footer">
                <p>Smart Home 2024 - Switch Dev Grupo 1</p>
            </div>
        </div>
    );
}

export default MainPage;

import React, {useState} from "react";
import Navbar from "react-bootstrap/Navbar";
import {LinkContainer} from "react-router-bootstrap";
import Nav from "react-bootstrap/Nav";
import {Col, Container, Row} from "react-bootstrap";
import {DarkModeSwitch} from "react-toggle-dark-mode";
import Routes from "../../router/Routes";
import BreadCrumbs from "../../components/Breadcrumbs/Breadcrumbs";
import Guest from "../Guest/Guest";
import Receptionist from "../Receptionist/Receptionist";
import Admin from "../Admin/Admin";
import Patient from "../Patient/Patient";

function Wszystko() {
    const [isDarkMode, setIsDarkMode] = useState(() => false);
    const urlPL = "https://img.icons8.com/color/96/000000/poland-circular.png"
    const urlEN = "https://img.icons8.com/color/48/000000/great-britain-circular.png"
    const [language, setLanguage] = useState(() => "PL");
    const [flag, setFlag] = useState(() => urlEN);

    function handleOnClick() {
        if (language === "EN") {
            setPL()
        } else {
            setEN()
        }
    }

    function setEN() {
        setLanguage("EN");
        setFlag(urlPL);
    }

    function setPL() {
        setLanguage("PL");
        setFlag(urlEN);
    }

    return (
        <div className="App container py-3 ">
            <Navbar collapseOnSelect bg="light" expand="md" className="shadow-box-example mb-3">
                <div style={{width: "100%"}}>
                    <Container fluid>
                        <Row>
                            <Col>
                                <LinkContainer to="/">
                                    <Navbar.Brand className="font-weight-bold text-muted">
                                        Home
                                    </Navbar.Brand>
                                </LinkContainer>
                            </Col>
                            <Col>
                                <Navbar.Toggle/>
                                <Navbar.Collapse className="justify-content-end">
                                   <Wybierz/>
                                    <DarkModeSwitch
                                        style={{marginLeft: '1rem'}}
                                        checked={isDarkMode}
                                        onChange={setIsDarkMode}
                                        size={30}
                                        sunColor={"#FFDF37"}
                                        moonColor={"#bfbfbb"}
                                    />
                                    <img onClick={handleOnClick} style={{marginLeft: "10px", maxWidth: "30px"}}
                                         src={flag} alt="Logo"/>

                                </Navbar.Collapse>
                            </Col>
                        </Row>
                        <Row> <Col> <BreadCrumbs/> </Col></Row>
                    </Container>
                </div>
            </Navbar>
            <Routes/>
        </div>
    );

}

function Wybierz() {
    // TODO: Wybór na podstawie aktualnej roli
    return Patient();
}

export default Wszystko;
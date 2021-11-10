import React, { useEffect, useState } from "react"
import { Table, Tab, Nav, Col, Row } from 'react-bootstrap'
import axios from 'axios';

function PlayersList() {
    const [data, setData] = useState([]);
    const [category, setCategory] = useState([]);
    const categories = ["Overall", "Attack", "Defense", "Magic", "Cooking", "Crafting"];

    useEffect(() => {
        selectCategory({ "item": categories[0] });
    }, [])

    function selectCategory(category) {
        setCategory(category.item);
        getData(category.item);
    }

    async function getData(category) {
        if (category == "") {
            category = categories[0];
        }
        let result = await axios.get("http://localhost:8080/api/v1/players/" + category);
        result = await result.data;
        const playersList = result.map((player, i) => ({
            id: i + 1, name: player.playerName, level: player.level,
            score: player.score
        }));
        setData(playersList);
    }

    return (
        <>
            <h3 className="heading">Old School Hardcore Ironman - Hiscores
                Home</h3>
            <div className="col-sm-6 offset-sm-3 page-wrapper">
                {
                    <Tab.Container id="left-tabs-example" defaultActiveKey={categories[0]}>
                        <Row>
                            <Col sm={3}>
                                <Nav variant="pills" className="flex-column">
                                    {
                                        categories.map((item) =>
                                            <Nav.Item>
                                                <Nav.Link eventKey={item} onClick={() => selectCategory({ item })}>{item}</Nav.Link>
                                            </Nav.Item>
                                        )
                                    }
                                </Nav>
                            </Col>
                            <Col sm={9}>
                                <Tab.Content>
                                    <Tab.Pane eventKey={category}>
                                        <h4 className="tab-heading">{category} Highscores</h4>
                                        {
                                            data.length > 0 ?
                                                <Table>
                                                    <tr>
                                                        <th>Rank</th>
                                                        <th>Name</th>
                                                        <th>Level</th>
                                                        <th>XP</th>
                                                    </tr>
                                                    {
                                                        data.map((item) =>
                                                            <tr key={item.id}>
                                                                <td>{item.id}</td>
                                                                <td>{item.name}</td>
                                                                <td>{item.level}</td>
                                                                <td>{item.score}</td>
                                                            </tr>
                                                        )
                                                    }
                                                </Table>
                                                : <p>No players found in this category</p>
                                        }
                                    </Tab.Pane>
                                </Tab.Content>
                            </Col>
                        </Row>
                    </Tab.Container>
                }
            </div>
        </>
    )
}
export default PlayersList
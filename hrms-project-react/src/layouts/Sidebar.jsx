import React, {useState, useEffect} from 'react'
import {Menu,Checkbox,Dropdown} from 'semantic-ui-react'
import SectorService from "../../src/services/SectorService"


export default function Sidebar() {
    const [sectors, setsSectors] = useState([]);
    useEffect(() => {
      let sectorService = new SectorService();
      sectorService.getAllSectors().then((result) => setsSectors(result.data.data));
    });

    return (
        <div>
        <Menu vertical>
        <Menu.Item>
          <Menu.Header>Sectors</Menu.Header>
          <Menu.Item>
          {sectors.map((sector) => (
          <Checkbox>{sector.sectorName}</Checkbox> ))}
          </Menu.Item>
          </Menu.Item>

          <Menu.Item>
          <Menu.Header>Job</Menu.Header>
          <Menu.Item>
          <Checkbox>Job Name</Checkbox>
          </Menu.Item>
          </Menu.Item>

          <Menu.Item>
          <Menu.Header>City</Menu.Header>
          <Menu.Item>
          <Dropdown placeholder='City' search />
          </Menu.Item>
          </Menu.Item>
          </Menu>
        </div>
    )
}

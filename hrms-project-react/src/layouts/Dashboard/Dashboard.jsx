import React from 'react'
import Sidebar from '../Sidebar'
import JobAdvertisements from '../../pages/JobAdvertisements'
import {Grid} from 'semantic-ui-react'

export default function Dashboard() {
    return (
        <div>
            <Grid>
                <Grid.Row className="grid">
                    <Grid.Column width={3}>
                        <Sidebar/>
                    </Grid.Column>
                    <Grid.Column width={13}>
                        <JobAdvertisements/>
                        </Grid.Column>
                </Grid.Row>            
            </Grid>
        </div>
    )
}

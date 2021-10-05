import React from 'react'
import Sidebar from '../Sidebar'
import JobAdvertisements from '../../pages/JobAdvertisement/JobAdvertisements';
import { Grid } from 'semantic-ui-react';
import { Route } from 'react-router';

export default function Dashboard() {
    return (
        <div>
            <Grid>
                <Grid.Row>
                    <Grid.Column width={4}>
                        <Route exact path="/advertisements" component={Sidebar} />
                    </Grid.Column>
                    <Grid.Column width={12}>
                        <Route exact path="/advertisements" component={JobAdvertisements} />
                    </Grid.Column>
                </Grid.Row>
            </Grid>
        </div>
    )
}

/*
 * OpenPixi - Open Particle-In-Cell (PIC) Simulator
 * Copyright (C) 2012  OpenPixi.org
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc.,
 * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 */

package org.openpixi.pixi.physics;

import java.util.ArrayList;

import org.openpixi.pixi.physics.Particle2D;
import org.openpixi.pixi.physics.boundary.*;
import org.openpixi.pixi.physics.force.Force;

public class Simulation {
	
	public static final int num_particles = 1000;
	public static final double particle_radius = 0.1;
	/**Total number of timesteps*/
	public static final int steps = 1000;
	/**Timestep*/
	public static double tstep = 1;
	/**Width of simulated area*/
	public static double width = 100;
	/**Height of simulated area*/
	public static double  height = 100;
	
	public static int num_cells_x = 10;
	static int num_cells_y = 10;
	static final double cell_width = width/num_cells_x;
	static final double cell_height = height/num_cells_y;
	
	/**Contains all Particle2D objects*/
	public static ArrayList<Particle2D> particles = new ArrayList<Particle2D>(num_particles);
	public static Force  f= new Force();
	public static Boundary boundary = new HardWallBoundary();

	public static CurrentGrid currentGrid = new CurrentGrid();

	public static void setSize(double width, double height) {
		Simulation.width = width;
		Simulation.height = height;
		Simulation.boundary.setBoundaries(0, 0, width, height);
		Simulation.currentGrid.setGrid(width, height);
	}

	public static void step() {
		ParticleMover.particlePush();
		Simulation.currentGrid.updateGrid(Simulation.particles);
		//collision.check(parlist, f, s, Simulation.tstep);
	}

}

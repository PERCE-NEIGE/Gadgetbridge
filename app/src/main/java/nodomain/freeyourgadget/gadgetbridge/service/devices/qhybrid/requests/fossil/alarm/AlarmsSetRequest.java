/*  Copyright (C) 2019-2020 Daniel Dakhno

    This file is part of Gadgetbridge.

    Gadgetbridge is free software: you can redistribute it and/or modify
    it under the terms of the GNU Affero General Public License as published
    by the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    Gadgetbridge is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU Affero General Public License for more details.

    You should have received a copy of the GNU Affero General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>. */
package nodomain.freeyourgadget.gadgetbridge.service.devices.qhybrid.requests.fossil.alarm;

import java.nio.ByteBuffer;

import nodomain.freeyourgadget.gadgetbridge.service.devices.qhybrid.adapter.fossil.FossilWatchAdapter;
import nodomain.freeyourgadget.gadgetbridge.service.devices.qhybrid.requests.fossil.file.FilePutRequest;

public class AlarmsSetRequest extends FilePutRequest {
    public AlarmsSetRequest(Alarm[] alarms, FossilWatchAdapter adapter) {
        super((short) 0x0A00, createFileFromAlarms(alarms), adapter);
    }

    static byte[] createFileFromAlarms(Alarm[] alarms){
        ByteBuffer buffer = ByteBuffer.allocate(alarms.length * 3);
        for(Alarm alarm : alarms) buffer.put(alarm.getData());

        return buffer.array();
    }
}

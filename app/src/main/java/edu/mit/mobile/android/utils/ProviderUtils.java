package edu.mit.mobile.android.utils;
/*
 * Copyright (C) 2010-2011 MIT Mobile Experience Lab
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.text.TextUtils;

public class ProviderUtils {

    /**
     * Adds extra where clauses
     * @param where
     * @param extraWhere
     * @return
     */
    public static String addExtraWhere(String where, String ... extraWhere){
        final String extraWhereJoined = "(" + TextUtils.join(") AND (", Arrays.asList(extraWhere))
                + ")";
            return extraWhereJoined + (where != null && where.length() > 0 ? " AND ("+where+")":"");
    }

    /**
     * Adds in extra arguments to a where query. You'll have to put in the appropriate
     * @param whereArgs the original whereArgs passed in from the query. Can be null.
     * @param extraArgs Extra arguments needed for the query.
     * @return
     */
    public static String[] addExtraWhereArgs(String[] whereArgs, String...extraArgs){
            final List<String> whereArgs2 = new ArrayList<String>();
            if (whereArgs != null){
                    whereArgs2.addAll(Arrays.asList(whereArgs));
            }
            whereArgs2.addAll(0, Arrays.asList(extraArgs));
            return whereArgs2.toArray(new String[]{});
    }
}
